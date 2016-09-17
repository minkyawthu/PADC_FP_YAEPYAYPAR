package com.padc.yaepyaypar.views.pods;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.controllers.BaseController;
import com.padc.yaepyaypar.controllers.UserController;
import com.padc.yaepyaypar.controllers.ViewController;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mkt on 9/14/2016.
 */
public class ViewPodLogoutUser extends RelativeLayout implements ViewController{

    private UserController mController;

    public ViewPodLogoutUser(Context context) {
        super(context);
    }

    public ViewPodLogoutUser(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewPodLogoutUser(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(Button button) {
        mController.onTapLogin();
    }

    @OnClick(R.id.btn_register)
    public void onTapRegister(Button button) {
        mController.onTapRegister();
    }

    @Override
    public void setController(BaseController controller) {
        mController = (UserController) controller;
    }
}
