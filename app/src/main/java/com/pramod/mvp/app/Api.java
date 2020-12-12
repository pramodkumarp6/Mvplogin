package com.pramod.mvp.app;

import com.pramod.mvp.model.LoginResponse;
import com.pramod.mvp.model.LoginSender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST("api/public/login")
    Call<LoginResponse> userLogin(@Body LoginSender loginSender);

}
