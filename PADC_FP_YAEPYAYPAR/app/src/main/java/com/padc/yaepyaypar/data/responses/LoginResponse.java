package com.padc.yaepyaypar.data.responses;

import com.google.gson.annotations.SerializedName;
import com.padc.yaepyaypar.data.vos.UserVO;

/**
 * Created by mkt on 9/17/2016.
 */
public class LoginResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private UserVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UserVO getLoginUser() {
        return loginUser;
    }

}
