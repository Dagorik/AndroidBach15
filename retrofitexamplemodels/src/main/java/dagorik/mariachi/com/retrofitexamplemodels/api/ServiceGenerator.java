package dagorik.mariachi.com.retrofitexamplemodels.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dagorik on 19/07/17.
 */

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("http://beta.json-generator.com/");

    public static ServicesInterface createService(){
        if (retrofit == null){
            retrofit = builder.build();
        }
        return retrofit.create(ServicesInterface.class);
    }
}
