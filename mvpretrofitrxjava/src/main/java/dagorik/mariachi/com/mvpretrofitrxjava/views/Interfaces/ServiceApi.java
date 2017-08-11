package dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces;

import dagorik.mariachi.com.mvpretrofitrxjava.views.Models.Repos;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Dagorik on 10/08/17.
 */

public interface ServiceApi {

    @GET("/users/{username}")
    Observable<Repos> getUserIntoPath(@Path("username") String userName);

}
