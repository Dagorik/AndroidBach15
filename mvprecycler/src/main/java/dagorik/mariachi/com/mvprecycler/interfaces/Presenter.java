package dagorik.mariachi.com.mvprecycler.interfaces;

import java.util.List;

import dagorik.mariachi.com.mvprecycler.models.Person;

/**
 * Created by Dagorik on 11/08/17.
 */

public interface Presenter {

    void initRecyclerView(List<Person> personList);

    void loadData();



}
