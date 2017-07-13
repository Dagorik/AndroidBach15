package dagorik.mariachi.com.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.fragments.fragments.BlankFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private List<String> mListsaludines = new ArrayList<>();
    private BlankFragment fragment;
    private int posicionSaludo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        saludos();
        cambiarFragment(posicionSaludo);


    }

    private void cambiarFragment(int position) {

        fragment = new BlankFragment(mListsaludines.get(position));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayaut, fragment)
                .commit();

    }

    private void initView(){
        Button boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(this);
    }

    private void saludos() {
        mListsaludines.add("HOLA");
        mListsaludines.add("HELLO");
        mListsaludines.add("HI");
        mListsaludines.add("HOLI");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.boton:
                cambiarFragment(posicionSaludo++);
                if (posicionSaludo >= 4){
                    posicionSaludo=0;
                }
                break;
        }
    }
}
