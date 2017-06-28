package com.kumar.user.androidmvpunittesting.Login;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kumar.user.androidmvpunittesting.ActivityUtil;
import com.kumar.user.androidmvpunittesting.R;

import static android.widget.Toast.LENGTH_SHORT;

public class login_activity extends AppCompatActivity implements LoginView {

    private EditText username;
    private EditText password;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.passWord);

        loginPresenter=new LoginPresenter(this,new LoginService());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void onLoginclicked(View view) {

        loginPresenter.onLoginClicked();

    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public void showUserNameError(int resId) {

        username.setError(getString(resId));

    }

    @Override
    public String getPassWord() {
        return password.getText().toString();
    }

    @Override
    public void showPassWordError(int resId) {

        password.setError(getString(resId));

    }

    @Override
    public void startMainActivity() {

        new ActivityUtil(this).startMainActivity();

    }

    @Override
    public void showLoginError(int resId) {

        Toast.makeText(this, getString(resId), LENGTH_SHORT).show();

    }
}
