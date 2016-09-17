package com.padc.yaepyaypar.data.retrofits;

import com.padc.yaepyaypar.data.responses.LoginResponse;
import com.padc.yaepyaypar.data.responses.RegisterResponse;
import com.padc.yaepyaypar.utils.YaePyayParConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by mkt on 9/16/2016.
 */
public interface YaePyayParApi {

    @FormUrlEncoded
    @POST(YaePyayParConstants.API_REGISTER)
    Call<RegisterResponse> register(
            @Field(YaePyayParConstants.PARAM_NAME) String name,
            @Field(YaePyayParConstants.PARAM_EMAIL) String email,
            @Field(YaePyayParConstants.PARAM_PASSWORD) String password,
            @Field(YaePyayParConstants.PARAM_DATE_OF_BIRTH) String dateOfBirth,
            @Field(YaePyayParConstants.PARAM_COUNTRY_OF_ORIGIN) String countryOfOrigin);

    @FormUrlEncoded
    @POST(YaePyayParConstants.API_LOGIN)
    Call<LoginResponse> login(
            @Field(YaePyayParConstants.PARAM_EMAIL) String email,
            @Field(YaePyayParConstants.PARAM_PASSWORD) String password);
}
