package dagorik.mariachi.com.realmdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import dagorik.mariachi.com.realmdatabase.models.Curso;
import dagorik.mariachi.com.realmdatabase.models.User;
import dagorik.mariachi.com.realmdatabase.servicesRealm.RealmServices;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    RealmServices realmServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this); //Iniciando Realm

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("Test") //Nombre de la base de datos
                .schemaVersion(1) //Numero de version de la base de datos
                .deleteRealmIfMigrationNeeded()
                .build(); //Construye con las configuraciones establecidas

        Realm.setDefaultConfiguration(realmConfiguration);

        realmServices =new RealmServices(Realm.getDefaultInstance());
        realmTareas();
    }

    public void realmTareas(){
        realmServices.insertUser(1,"Edwin","edwin@devf.com",false);

        RealmResults<User> listUsers = realmServices.obtenerUsuarios();
        for (int i = 0; i<listUsers.size();i++){
            Log.e("MyLogFor",listUsers.get(i).getEmail());
        }
//        Log.e("MyLog",listUsers+"");

        //User user = realmServices.obtenerUsuarioId(2);
        //Log.e("MyLogID",user.getName());

        //realmServices.actualizauser(user,"Brandon");
        //user = realmServices.obtenerUsuarioId(2);
        //Log.e("MyLogID",user.getName());

        //realmServices.borrarUser(1);

        //realmServices.insertarCurso(1,"Cinta Negra Android");
        RealmResults<Curso> cursoRealmResults = realmServices.obtenerCursos();
        Log.e("MyLogCursos",cursoRealmResults+"");
        Log.e("MyLogFor",cursoRealmResults.get(0).getUsers().get(0).getEmail());
//        for (int i = 0; i < cursoRealmResults.size(); i++){
//            Log.e("MyLogFor",cursoRealmResults.get(0).getUsers().get(1).getEmail());
//        }

    }
}
