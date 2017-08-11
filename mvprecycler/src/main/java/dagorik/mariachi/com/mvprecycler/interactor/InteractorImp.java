package dagorik.mariachi.com.mvprecycler.interactor;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.mvprecycler.interfaces.Interactor;
import dagorik.mariachi.com.mvprecycler.interfaces.Presenter;
import dagorik.mariachi.com.mvprecycler.models.Person;

/**
 * Created by Dagorik on 11/08/17.
 */

public class InteractorImp implements Interactor {

    List<Person> personList= new ArrayList<>();
    private Presenter presenter;

    public InteractorImp(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getListToPerson() {
        personList.add(new Person("Raul","Amador"));
        personList.add(new Person("Jorge","Perez"));
        personList.add(new Person("Pedro","Pacheco"));
        personList.add(new Person("Juan","Mendoza"));
        personList.add(new Person("Paco","Cruz"));
        personList.add(new Person("Jose","Tolentino"));
        personList.add(new Person("Julio","Hernandez"));

        presenter.initRecyclerView(personList);

    }
}
