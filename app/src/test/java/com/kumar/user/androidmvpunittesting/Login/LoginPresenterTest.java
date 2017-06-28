package com.kumar.user.androidmvpunittesting.Login;

import com.kumar.user.androidmvpunittesting.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by User on 6/28/2017.
 */

@RunWith(MockitoJUnitRunner.class)

public class LoginPresenterTest {

    @Mock
    private LoginView loginView;

    @Mock
    private LoginService loginService;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        loginPresenter=new LoginPresenter(loginView,loginService);
    }

    @Test
    public void shouldShowErrorMessageWhenUsernameIsEmpty() throws Exception{
        when(loginView.getUserName()).thenReturn("");

        loginPresenter.onLoginClicked();
        verify(loginView).showUserNameError(R.string.username_error);
    }
    @Test
    public void shouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(loginView.getUserName()).thenReturn("chaitanya");
        when(loginView.getPassWord()).thenReturn("");
        loginPresenter.onLoginClicked();

        verify(loginView).showPassWordError(R.string.password_error);
    }

    @Test
    public void shouldStartMainActivityWhenUsernameAndPasswordAreCorrect() throws Exception {
        when(loginView.getUserName()).thenReturn("chaitanya");
        when(loginView.getPassWord()).thenReturn("kumar");
        when(loginService.Login("chaitanya", "kumar")).thenReturn(true);
        loginPresenter.onLoginClicked();
        verify(loginView).startMainActivity();
    }

    @Test
    public void shouldShowLoginErrorWhenUsernameAndPasswordAreInvalid() throws Exception {
        when(loginView.getUserName()).thenReturn("chaitanya");
        when(loginView.getPassWord()).thenReturn("kumar");
        when(loginService.Login("chaitanya", "kumar")).thenReturn(false);
        loginPresenter.onLoginClicked();

        verify(loginView).showLoginError(R.string.login_failed);
    }
}