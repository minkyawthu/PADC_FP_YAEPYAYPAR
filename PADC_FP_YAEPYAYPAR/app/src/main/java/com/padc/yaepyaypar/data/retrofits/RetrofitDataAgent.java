package com.padc.yaepyaypar.data.retrofits;

import com.padc.yaepyaypar.data.agents.YaePyayParDataAgent;
import com.padc.yaepyaypar.data.responses.LoginResponse;
import com.padc.yaepyaypar.data.responses.RegisterResponse;
import com.padc.yaepyaypar.events.UserEvent;
import com.padc.yaepyaypar.utils.CommonInstances;
import com.padc.yaepyaypar.utils.YaePyayParConstants;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mkt on 9/16/2016.
 */
public class RetrofitDataAgent implements YaePyayParDataAgent{

    private static RetrofitDataAgent objInstance;

    private final YaePyayParApi theApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YaePyayParConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(YaePyayParApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }


    @Override
    public void register(String name, String email, String password, String dateOfBirth, String countryOfOrigin) {
        Call<RegisterResponse> registerCall = theApi.register(name, email, password, dateOfBirth, countryOfOrigin);
        registerCall.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse registerResponse = response.body();
                if (registerResponse == null) {
                    UserEvent.FailedRegistrationEvent event = new UserEvent.FailedRegistrationEvent(response.message());
                    EventBus.getDefault().post(event);
                } else {
                    UserEvent.SuccessRegistrationEvent event = new UserEvent.SuccessRegistrationEvent(registerResponse.getLoginUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                UserEvent.FailedRegistrationEvent event = new UserEvent.FailedRegistrationEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });

    }

    @Override
    public void login(String email, String password) {
        Call<LoginResponse> loginCall = theApi.login(email, password);
        loginCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    UserEvent.FailedLoginEvent event = new UserEvent.FailedLoginEvent(response.message());
                    EventBus.getDefault().post(event);
                } else {
                    UserEvent.SuccessLoginEvent event = new UserEvent.SuccessLoginEvent(loginResponse.getLoginUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                UserEvent.FailedLoginEvent event = new UserEvent.FailedLoginEvent(t.getMessage());
                EventBus.getDefault().post(event);
            }
        });

    }
}
