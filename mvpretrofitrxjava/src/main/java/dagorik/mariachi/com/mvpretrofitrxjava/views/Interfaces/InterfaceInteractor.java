package dagorik.mariachi.com.mvpretrofitrxjava.views.Interfaces;

import dagorik.mariachi.com.mvpretrofitrxjava.views.Models.Repos;

/**
 * Created by Dagorik on 10/08/17.
 */

public interface InterfaceInteractor {

    void getDataGit(String user);

    void handleResults(Repos repos);

    void handleError(Throwable throwable);
}
