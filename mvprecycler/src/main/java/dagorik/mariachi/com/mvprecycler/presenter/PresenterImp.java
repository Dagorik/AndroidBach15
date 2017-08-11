package dagorik.mariachi.com.mvprecycler.presenter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

import dagorik.mariachi.com.mvprecycler.adapter.AdaptadorPerson;
import dagorik.mariachi.com.mvprecycler.interactor.InteractorImp;
import dagorik.mariachi.com.mvprecycler.interfaces.Interactor;
import dagorik.mariachi.com.mvprecycler.interfaces.MainView;
import dagorik.mariachi.com.mvprecycler.interfaces.Presenter;
import dagorik.mariachi.com.mvprecycler.models.Person;

/**
 * Created by Dagorik on 11/08/17.
 */

public class PresenterImp  implements Presenter{


    private MainView view;
    private Interactor interactor;

    public PresenterImp(MainView view) {
        this.view = view;
        this.interactor = new InteractorImp(this);

    }


    @Override
    public void initRecyclerView(List<Person> personList) {
        view.setRecyclerView(personList);

    }

    @Override
    public void loadData() {

        interactor.getListToPerson();

    }
}
