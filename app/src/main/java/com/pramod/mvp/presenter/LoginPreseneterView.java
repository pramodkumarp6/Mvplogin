package com.pramod.mvp.presenter;

public interface LoginPreseneterView {

    void onSucess();
    void onError(String msg);
    void onHide();
    void onShow();
}
