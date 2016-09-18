package com.padc.yaepyaypar.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.controllers.UserSessionController;
import com.padc.yaepyaypar.data.models.UserModel;
import com.padc.yaepyaypar.dialogs.SharedDialog;
import com.padc.yaepyaypar.events.UserEvent;
import com.padc.yaepyaypar.fragments.LoginFragment;
import com.padc.yaepyaypar.fragments.RegisterFragment;
import com.padc.yaepyaypar.Utils.SecurityUtils;

import de.greenrobot.event.EventBus;

/**
 * Created by mkt on 9/14/2016.
 */
public class AccountControlActivity extends BaseActivity implements UserSessionController{

    public static final int NAVIGATE_TO_REGISTER = 1;
    public static final int NAVIGATE_TO_LOGIN = 2;

    public static final int RC_ACCOUNT_CONTROL_REGISTER = 100;
    public static final int RC_ACCOUNT_CONTROL_LOGIN = 100;

    private static final String IE_NAVIGATE_TO = "IE_NAVIGATE_TO";

    public static final String IR_IS_REGISTER_SUCCESS = "IR_IS_REGISTER_SUCCESS";
    public static final String IR_IS_LOGIN_SUCCESS = "IR_IS_LOGIN_SUCCESS";

    private int mNavigateTo;

    public static Intent newIntent(int navigateTo) {
        Intent intent = new Intent(YaePyayParApp.getContext(), AccountControlActivity.class);
        intent.putExtra(IE_NAVIGATE_TO, navigateTo);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_control);

        mNavigateTo = getIntent().getIntExtra(IE_NAVIGATE_TO, NAVIGATE_TO_LOGIN);

        if (savedInstanceState == null) {
            Fragment fragment;
            switch (mNavigateTo) {
                case NAVIGATE_TO_REGISTER:
                    fragment = RegisterFragment.newInstance();
                    break;
                case NAVIGATE_TO_LOGIN:
                    fragment = LoginFragment.newInstance();
                    break;
                default:
                    throw new RuntimeException("Unsupported Account Control Type : " + mNavigateTo);
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);

    }

    @Override
    public void onRegister(String name, String email, String password, String dateOfBirth, String country) {

        showProgressDialog("Registering. Please wait.");
        password = SecurityUtils.encryptMD5(password);
        UserModel.getInstance().register(name, email, password, dateOfBirth, country);

    }

    @Override
    public void onLogin(String email, String password) {

        showProgressDialog("Logging In. Please wait.");
        password = SecurityUtils.encryptMD5(password);
        UserModel.getInstance().login(email, password);

    }

    //Success Register
    public void onEventMainThread(UserEvent.SuccessRegistrationEvent event) {
        Intent returningIntent = new Intent();
        returningIntent.putExtra(IR_IS_REGISTER_SUCCESS, true);
        setResult(Activity.RESULT_OK, returningIntent);
        finish();

        dismissProgressDialog();
    }

    //Failed to Register
    public void onEventMainThread(UserEvent.FailedRegistrationEvent event) {
        dismissProgressDialog();
        SharedDialog.promptMsgWithTheme(this, event.getMessage());
    }

    //Success Login
    public void onEventMainThread(UserEvent.SuccessLoginEvent event) {
        Intent returningIntent = new Intent();
        returningIntent.putExtra(IR_IS_LOGIN_SUCCESS, true);
        setResult(Activity.RESULT_OK, returningIntent);
        finish();

        dismissProgressDialog();
    }

    //Failed to Login
    public void onEventMainThread(UserEvent.FailedLoginEvent event) {
        dismissProgressDialog();
        SharedDialog.promptMsgWithTheme(this, event.getMessage());
    }
}
