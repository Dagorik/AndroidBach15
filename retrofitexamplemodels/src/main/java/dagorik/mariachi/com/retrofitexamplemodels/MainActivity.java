package dagorik.mariachi.com.retrofitexamplemodels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import dagorik.mariachi.com.retrofitexamplemodels.api.ServiceGenerator;
import dagorik.mariachi.com.retrofitexamplemodels.api.ServicesInterface;
import dagorik.mariachi.com.retrofitexamplemodels.models.Ejemplo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loadData();
        loadDataSingleton();
    }

    private void loadDataSingleton() {
        ServicesInterface servicesInterface = ServiceGenerator.createService();
        servicesInterface.loadData().enqueue(new Callback<List<Ejemplo>>() {
            @Override
            public void onResponse(Call<List<Ejemplo>> call, Response<List<Ejemplo>> response) {
                for (int i = 0; i < response.body().size(); i++){
                    String title = response.body().get(i).getComment();
                    Log.e("MyLogTitle",title);
                }
            }

            @Override
            public void onFailure(Call<List<Ejemplo>> call, Throwable t) {

            }
        });
    }

    public void loadData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://beta.json-generator.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        final ServicesInterface cliente = retrofit.create(ServicesInterface.class);

        cliente.loadData().enqueue(new Callback<List<Ejemplo>>() {
            @Override
            public void onResponse(Call<List<Ejemplo>> call, Response<List<Ejemplo>> response) {

                for (int i = 0; i < response.body().size(); i++){
                    String title = response.body().get(i).getComment();
                    Log.e("MyLogTitle",title);

                }


            }

            @Override
            public void onFailure(Call<List<Ejemplo>> call, Throwable t) {

            }
        });
    }
}
