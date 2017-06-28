package com.kumar.user.androidmvpunittesting.Login;

/**
 * Created by User on 6/28/2017.
 */

public interface LoginView {

    String getUserName();

    void showUserNameError(int resId);

    String getPassWord();

    void showPassWordError(int resId);

    void startMainActivity();

    void showLoginError(int resId);


}
