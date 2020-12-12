package com.pramod.mvp.presenter;

import com.pramod.mvp.model.LoginModel;
import com.pramod.mvp.model.LoginResponse;
import com.pramod.mvp.view.LoginView;

public class LoginPresenter implements LoginPreseneterView {
    private LoginView view;
    private LoginModel loginModel;

    public LoginPresenter(LoginView view) {
        this.view = view;
        loginModel = new LoginModel(this);
    }

    public void loginValidate(String email,String password){
        loginModel.validate(email,password);

    }

    @Override
    public void onSucess() {

    }

    @Override
    public void onError(String msg) {
        view.onError(msg);

    }

    @Override
    public void onHide() {
        view.onHide();

    }

    @Override
    public void onShow() {
        view.onShow();

    }
}
