package dagorik.mariachi.com.mvplogin.presenter;

import java.util.Objects;

import dagorik.mariachi.com.mvplogin.interactor.LoginInteractorimp;
import dagorik.mariachi.com.mvplogin.interfaces.LoginInteractor;
import dagorik.mariachi.com.mvplogin.interfaces.LoginPresenter;
import dagorik.mariachi.com.mvplogin.interfaces.LoginView;
import dagorik.mariachi.com.mvplogin.interfaces.OnListenerLogin;

/**
 * Created by Dagorik on 04/08/17.
 */

public class LoginPresenterImp implements LoginPresenter, OnListenerLogin {

    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorimp();
    }

    @Override
    public void validarCredenciales(String user, String pass) {
        if (loginView != null) {
            loginView.showProgressBar();
        }

        loginInteractor.solicitarDatos(user, pass, this);
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.successLogin();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void OnPasswordError() {

        loginView.erroLogin();
        loginView.hideProgressBar();
    }

}
