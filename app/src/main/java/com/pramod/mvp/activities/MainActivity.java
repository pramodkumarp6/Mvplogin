package com.pramod.mvp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.pramod.mvp.databinding.ActivityMainBinding;
import com.pramod.mvp.presenter.LoginPresenter;
import com.pramod.mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private ActivityMainBinding activityMainBinding;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        getSupportActionBar().setTitle("Login");
        progressDialog = new ProgressDialog(this);
        loginPresenter = new LoginPresenter(this);

        activityMainBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();


            }
        });

    }


    public void Login(){
        final String email = activityMainBinding.editTextemail.getText().toString().trim();
        final String password = activityMainBinding.editTextPassword.getText().toString().trim();
        loginPresenter.loginValidate(email,password);
    }

    @Override
    public void onSucess() {
        Toast.makeText(this,"Sucess",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onHide() {
        progressDialog.hide();

    }

    @Override
    public void onShow() {
        progressDialog.show();

    }
}