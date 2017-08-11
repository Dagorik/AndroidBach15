package dagorik.mariachi.com.mvprecycler.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import dagorik.mariachi.com.mvprecycler.R;
import dagorik.mariachi.com.mvprecycler.adapter.AdaptadorPerson;
import dagorik.mariachi.com.mvprecycler.interfaces.MainView;
import dagorik.mariachi.com.mvprecycler.interfaces.OnRecyclerViewItemClickListener;
import dagorik.mariachi.com.mvprecycler.interfaces.Presenter;
import dagorik.mariachi.com.mvprecycler.models.Person;
import dagorik.mariachi.com.mvprecycler.presenter.PresenterImp;

public class MainActivity extends AppCompatActivity implements MainView{

    Presenter presenter;
    AdaptadorPerson personAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PresenterImp(this);


        presenter.loadData();


    }


    @Override
    public void setRecyclerView(List<Person> persons) {
        Log.e("MyLOg","Se ejecuto");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setHasFixedSize(true);

        personAdapter = new AdaptadorPerson(persons);

        recyclerView.setAdapter(personAdapter);

    }



}
