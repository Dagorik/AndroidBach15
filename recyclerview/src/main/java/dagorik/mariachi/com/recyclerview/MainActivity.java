package dagorik.mariachi.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.recyclerview.adapters.PesoAdaptador;
import dagorik.mariachi.com.recyclerview.models.Peso;

public class MainActivity extends AppCompatActivity {

    private List<Peso> pesos = new ArrayList<>();
    private RecyclerView listaPesos;
    private PesoAdaptador pesoAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPeso();
        inicializaAdaptador();
    }

    private void initPeso() {
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","72"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
        pesos.add(new Peso("01/01/2018","78"));
        pesos.add(new Peso("02/01/2018","79"));
        pesos.add(new Peso("03/01/2018","72"));
        pesos.add(new Peso("04/01/2018","73"));
        pesos.add(new Peso("05/01/2018","74"));
        pesos.add(new Peso("06/01/2018","72"));
        pesos.add(new Peso("07/01/2018","73"));
        pesos.add(new Peso("08/01/2018","71"));
        pesos.add(new Peso("09/01/2018","75"));
    }

    private void inicializaAdaptador(){
        listaPesos = (RecyclerView) findViewById(R.id.rv_lista);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaPesos.setLayoutManager(layoutManager);

        pesoAdaptador = new PesoAdaptador(pesos);
        listaPesos.setAdapter(pesoAdaptador);

    }
}
