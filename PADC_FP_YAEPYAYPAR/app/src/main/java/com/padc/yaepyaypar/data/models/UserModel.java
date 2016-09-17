package com.padc.yaepyaypar.data.models;

import com.padc.yaepyaypar.data.retrofits.RetrofitDataAgent;
import com.padc.yaepyaypar.data.vos.UserVO;
import com.padc.yaepyaypar.events.UserEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by mkt on 9/16/2016.
 */
public class UserModel {

    private static UserModel objInstance;
    private RetrofitDataAgent dataAgent;
    private UserVO loginUser;

    private UserModel() {
        super();
        dataAgent = RetrofitDataAgent.getInstance();

        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    public void init() {
        /*loginUser = UserVO.loadLoginUser();*/

        if (loginUser != null) {
            UserEvent.RefreshUserLoginStatusEvent event = new UserEvent.RefreshUserLoginStatusEvent();
            EventBus.getDefault().postSticky(event);
        }
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    public boolean isUserLogin() {
        return loginUser != null;
    }

    public UserVO getLoginUser() {
        return loginUser;
    }

    public void login(String email, String password) {
        dataAgent.login(email, password);
    }

    public void register(String name, String email, String password, String dateOfBirth, String country) {
        dataAgent.register(name, email, password, dateOfBirth, country);
    }

    public void logout() {

        loginUser = null;

        UserEvent.RefreshUserLoginStatusEvent event = new UserEvent.RefreshUserLoginStatusEvent();
        EventBus.getDefault().postSticky(event);
    }

    //Success Register
    public void onEventMainThread(UserEvent.SuccessRegistrationEvent event) {
        if (loginUser == null) {
            loginUser = event.getLoginUser();
        } else {
            loginUser.setAccessToken(event.getLoginUser().getAccessToken());
            loginUser.setDateOfBirthText(event.getLoginUser().getDateOfBirthText());
            loginUser.setCountryOfOrigin(event.getLoginUser().getCountryOfOrigin());
        }


    }

    //Failed to Register
    public void onEventMainThread(UserEvent.FailedRegistrationEvent event) {
        //Do nothing on persistent layer.
    }

    //Success Login
    public void onEventMainThread(UserEvent.SuccessLoginEvent event) {
        if (loginUser == null) {
            loginUser = event.getLoginUser();
        } else {
            loginUser.setAccessToken(event.getLoginUser().getAccessToken());
            loginUser.setDateOfBirthText(event.getLoginUser().getDateOfBirthText());
            loginUser.setCountryOfOrigin(event.getLoginUser().getCountryOfOrigin());
            loginUser.setRegisteredDate(event.getLoginUser().getRegisteredDate());
        }

    }

    //Failed to Login
    public void onEventMainThread(UserEvent.FailedLoginEvent event) {
        //Do nothing on persistent layer.
    }
}
