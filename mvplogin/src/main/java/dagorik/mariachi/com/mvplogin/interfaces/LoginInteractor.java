package dagorik.mariachi.com.mvplogin.interfaces;

/**
 * Created by Dagorik on 04/08/17.
 */

public interface LoginInteractor {

    void solicitarDatos(String user, String pass, OnListenerLogin onListenerLogin);

}
