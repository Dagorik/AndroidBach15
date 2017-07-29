package dagorik.mariachi.com.retrofitexamplemodels.api;

import java.util.List;

import dagorik.mariachi.com.retrofitexamplemodels.models.Ejemplo;
import dagorik.mariachi.com.retrofitexamplemodels.models.modeloEjemplo.Objeto;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Dagorik on 19/07/17.
 */


public interface ServicesInterface {

    @GET("/api/json/get/EkphH5xyM")
    //Se hace el call a la lista del modelo de ejmplos
    Call<List<Ejemplo>> loadData();

    @POST("/ldalñ/")
    Call<Objeto> pedirObjeto(@Body Objeto objeto);

}
