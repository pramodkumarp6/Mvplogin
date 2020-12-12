package com.pramod.mvp.model;

import com.pramod.mvp.app.RetrofitClient;
import com.pramod.mvp.presenter.LoginPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginModelView {
    private LoginPresenter loginPresenter;
    private LoginSender loginSender;


    public LoginModel(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }



    @Override
    public void validate(String email, String password) {
        loginSender = new LoginSender(email,password);

        if(email.isEmpty()){
            loginPresenter.onError("Enter Email id!");
        }

        if(password.isEmpty()){
            loginPresenter.onError("Enter Email id!");

        }


        loginPresenter.onShow();

        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().userLogin(loginSender);
         call.enqueue(new Callback<LoginResponse>() {
             @Override
             public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                 LoginResponse loginResponse = response.body();
                 loginPresenter.onHide();
                 if(loginResponse.getStatus() == 200){
                     loginPresenter.onSucess();

                 }else{
                     loginPresenter.onError(response.body().getMessage());
                 }

             }

             @Override
             public void onFailure(Call<LoginResponse> call, Throwable t) {

             }
         });


    }
}
