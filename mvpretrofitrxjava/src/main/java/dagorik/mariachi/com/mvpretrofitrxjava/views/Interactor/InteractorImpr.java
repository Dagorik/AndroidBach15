package dagorik.mariachi.com.mvpretrofitrxjava.views.Interactor;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfaceInteractor;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.InterfacePresenter;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces.ServiceApi;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Models.Repos;
import dagorik.mariachi.com.mvpretrofitrxjava.views.Presenter.PresenterImp;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dagorik on 10/08/17.
 */

public class InteractorImpr implements InterfaceInteractor {

    Retrofit retrofit;
    ServiceApi serviceApi;
    InterfacePresenter presenter;

    public InteractorImpr(PresenterImp presenterImp) {
        this.presenter = presenterImp;
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com")
                .build();

        serviceApi = retrofit.create(ServiceApi.class);


    }

    @Override
    public void getDataGit(String user) {
        Observable<Repos> responseBodyObservable = serviceApi.getUserIntoPath(user);
        responseBodyObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError );


        //Observable.just(retrofit.create(ServiceApi.class))



    }

    @Override
    public void handleResults(Repos repos) {
        presenter.showSuccess(repos.toString());
    }

    @Override
    public void handleError(Throwable throwable) {
        presenter.showError(throwable.getMessage());
    }
}
