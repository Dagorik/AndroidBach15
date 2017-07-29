package dagorik.mariachi.com.retrofitexamplemodels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dagorik.mariachi.com.retrofitexamplemodels.adapter.AdapterEjemplo;
import dagorik.mariachi.com.retrofitexamplemodels.api.ServiceGenerator;
import dagorik.mariachi.com.retrofitexamplemodels.api.ServicesInterface;
import dagorik.mariachi.com.retrofitexamplemodels.models.Ejemplo;
import dagorik.mariachi.com.retrofitexamplemodels.models.modeloEjemplo.Contactos;
import dagorik.mariachi.com.retrofitexamplemodels.models.modeloEjemplo.Objeto;
import dagorik.mariachi.com.retrofitexamplemodels.models.modeloEjemplo.Phone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListEjemplo;
    List<Ejemplo> ejemploList = new ArrayList<>();
    AdapterEjemplo adapterEjemplo;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loadData();
        loadDataSingleton();

        Objeto objeto = new Objeto();
        objeto.getContactos().get(1).getPhoner().getMobile();

         nombre = "Brandon";
    }

    private void loadDataSingleton() {
        ServicesInterface servicesInterface = ServiceGenerator.createService();


        servicesInterface.loadData().enqueue(new Callback<List<Ejemplo>>() {
            @Override
            public void onResponse(Call<List<Ejemplo>> call, Response<List<Ejemplo>> response) {


                for (int i = 0; i < response.body().size(); i++){
                    String title = response.body().get(i).getPicture();
                    Log.e("MyLogTitle",title);
                }

                ejemploList = response.body();
                setupRecyler(ejemploList);
                adapterEjemplo.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Ejemplo>> call, Throwable t) {

            }
        });


        Phone phone = new Phone();
        phone.setMobile(782178931);
        phone.setTel(982475984);

        Contactos contactos = new Contactos();
        contactos.setName(nombre);
        contactos.setId("1");
        contactos.setPhoner(phone);



        Objeto objeto = new Objeto();

        objeto.setContactos((List<Contactos>) contactos);

        servicesInterface.pedirObjeto(objeto).enqueue(new Callback<Objeto>() {
            @Override
            public void onResponse(Call<Objeto> call, Response<Objeto> response) {

            }

            @Override
            public void onFailure(Call<Objeto> call, Throwable t) {

            }
        });


    }




    private void setupRecyler(List<Ejemplo> list){
        rvListEjemplo = (RecyclerView) findViewById(R.id.rv_ejemplo);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvListEjemplo.setHasFixedSize(true);
        rvListEjemplo.setLayoutManager(layoutManager);


        adapterEjemplo = new AdapterEjemplo(list);

        rvListEjemplo.setAdapter(adapterEjemplo);

    }

//    public void loadData(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://beta.json-generator.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//
//        final ServicesInterface cliente = retrofit.create(ServicesInterface.class);
//
//        cliente.loadData().enqueue(new Callback<List<Ejemplo>>() {
//            @Override
//            public void onResponse(Call<List<Ejemplo>> call, Response<List<Ejemplo>> response) {
//
//                for (int i = 0; i < response.body().size(); i++){
//                    String title = response.body().get(i).getComment();
//                    Log.e("MyLogTitle",title);
//
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Ejemplo>> call, Throwable t) {
//
//            }
//        });
//    }
}
