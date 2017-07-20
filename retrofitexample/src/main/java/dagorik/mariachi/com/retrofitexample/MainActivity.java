package dagorik.mariachi.com.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRetrofitData();
    }

    public void getRetrofitData() {
        //Configuración basica de nuestro objeto Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();

        //Crear la instancia de mi interfaz que ya tiene configurado la estructura de mi solicitud
        GitHubService gitHubService = retrofit.create(GitHubService.class);

        gitHubService.getUserIntoPath("Dagorik").enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Obtenemos el código de respuesta
                int code = response.code();

                //Verificamos que el código sea 200
                if (code == 200) {
                    if (response.body() != null) {
                        try {
                            //Obtener el body del mensaje HTTP como String
                            String body = response.body().string();

                            //Persear el string como JSON
                            JSONObject jsonObject = new JSONObject(body);
                            Log.e("MyLog", jsonObject.toString());
                            Log.e("MyLog", jsonObject.getString("bio"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                } else if (code == 404) {
                    //Si el servicio nos contesta con un 404 mandamos el siguiente mensaje de error
                    Toast.makeText(MainActivity.this, "El usuario no existe!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Tuvimos un error, intenta mas tarde", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private interface GitHubService {
        //Nombre del metodo
        //URI del recurso que queremos obtener
        @GET("/users/Dagorik")
        public Call<ResponseBody> getUserInfo();

        @GET("/users/{username}")
        public Call<ResponseBody> getUserIntoPath(@Path("username") String userName);

    }

}
