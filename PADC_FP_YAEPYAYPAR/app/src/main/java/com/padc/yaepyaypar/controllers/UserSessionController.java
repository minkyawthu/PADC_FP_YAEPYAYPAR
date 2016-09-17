package com.padc.yaepyaypar.controllers;

/**
 * Created by mkt on 9/16/2016.
 */
public interface UserSessionController {
    void onRegister(String name, String email, String password, String dateOfBirth, String country);

    void onLogin(String email, String password);
}
