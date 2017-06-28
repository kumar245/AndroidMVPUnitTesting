package com.kumar.user.androidmvpunittesting.Login;

import com.kumar.user.androidmvpunittesting.R;

/**
 * Created by User on 6/28/2017.
 */

public class LoginPresenter {

    private LoginView loginView;
    private LoginService loginService;

    public LoginPresenter(LoginView loginView, LoginService loginService) {
        this.loginView = loginView;
        this.loginService = loginService;
    }

    public void onLoginClicked(){

        String username=loginView.getUserName();
        if (username.isEmpty()){
            loginView.showUserNameError(R.string.username_error);
            return;
        }

        String password=loginView.getPassWord();
        if (password.isEmpty()){
            loginView.showPassWordError(R.string.password_error);
            return;
        }
        boolean loginSucceeded = loginService.Login(username,password);
        if (loginSucceeded){
            loginView.startMainActivity();
            return;
        }
        loginView.showLoginError(R.string.login_failed);

    }
}
