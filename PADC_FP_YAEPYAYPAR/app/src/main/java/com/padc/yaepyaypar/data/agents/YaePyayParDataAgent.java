package com.padc.yaepyaypar.data.agents;

/**
 * Created by mkt on 9/16/2016.
 */
public interface YaePyayParDataAgent {
    void register(String name, String email, String password, String dateOfBirth, String countryOfOrigin);
    void login(String email, String password);
}
