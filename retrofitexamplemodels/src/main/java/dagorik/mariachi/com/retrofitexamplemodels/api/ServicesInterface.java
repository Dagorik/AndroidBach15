package dagorik.mariachi.com.retrofitexamplemodels.api;

import java.util.List;

import dagorik.mariachi.com.retrofitexamplemodels.models.Ejemplo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dagorik on 19/07/17.
 */


public interface ServicesInterface {

    @GET("/api/json/get/EkphH5xyM")
    //Se hace el call a la lista del modelo de ejmplos
    Call<List<Ejemplo>> loadData();
}
