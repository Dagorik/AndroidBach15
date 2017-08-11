package dagorik.mariachi.com.mvplogin.interactor;

import android.os.Handler;

import dagorik.mariachi.com.mvplogin.interfaces.LoginInteractor;
import dagorik.mariachi.com.mvplogin.interfaces.OnListenerLogin;

/**
 * Created by Dagorik on 04/08/17.
 */

public class LoginInteractorimp implements LoginInteractor {

    @Override
    public void solicitarDatos(final String user, final String pass, final OnListenerLogin onListenerLogin) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user.isEmpty() && pass.isEmpty()){
                    onListenerLogin.OnPasswordError();
                } else {
                    onListenerLogin.onSuccess();
                }
            }
        },2000);
    }


}
