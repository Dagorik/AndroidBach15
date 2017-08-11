package dagorik.mariachi.com.mvpretrofitrxjava.views.Presenter;

import android.util.Log;

import dagorik.mariachi.com.mvpretrofitrxjava.views.Interactor.InteractorImpr;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfaceInteractor;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfaceMain;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfacePresenter;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Views.MainActivity;

/**
 * Created by Dagorik on 10/08/17.
 */

public class PresenterImp implements InterfacePresenter {

    private InterfaceMain interfaceMain;
    private InterfaceInteractor interactor;

    public PresenterImp(MainActivity mainActivity) {
        this.interfaceMain = mainActivity;
        interactor = new InteractorImpr(this);
    }

    @Override
    public void getDataGit(String user) {
        Log.e("MyLogPresenter",user);
        interactor.getDataGit(user);
    }

    @Override
    public void showError(String error) {
        if (interfaceMain != null) {
            interfaceMain.showProgressBar(false);
            interfaceMain.showError(error);
        }

    }

    @Override
    public void showSuccess(String yeha) {
        if (interfaceMain != null) {
            interfaceMain.showProgressBar(false);
            interfaceMain.showMessageGit(yeha);
        }
    }
}
