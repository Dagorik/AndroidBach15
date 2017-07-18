package dagorik.mariachi.com.realmdatabase.servicesRealm;

import android.util.Log;

import dagorik.mariachi.com.realmdatabase.models.Curso;
import dagorik.mariachi.com.realmdatabase.models.User;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Dagorik on 13/07/17.
 */

public class RealmServices {
    Realm realm;

    public RealmServices(Realm realm) {
        this.realm = realm;
    }

    //Obtener usuarios
    public RealmResults<User> obtenerUsuarios(){
        RealmResults<User> listUsuarios = realm.where(User.class).findAll();
        return listUsuarios;
    }
    //Obtener un usuario por ID
    public User obtenerUsuarioId(int id){
        User user = realm.where(User.class).equalTo("id",id).findFirst();
        return user;
    }

    //Busqueda con parametros
    public RealmResults<User> busquedaPorEdad(){
        RealmResults<User> users = realm.where(User.class).between("edad", 0, 30).findAll();
//        RealmResults<User> users = realm.where(User.class).beginsWith("name", "E").findAll();
//        RealmResults<User> users = realm.where(User.class).contains("name", "i").findAll();
//        RealmResults<User> users = realm.where(User.class).greaterThanOrEqualTo("edad", 22).findAll();
//        RealmResults<User> users = realm.where(User.class).findAll().sort("edad", Sort.DESCENDING);

//        RealmResults<User> users = realm.where(User.class).between("edad", 20, 30).findAll();
//        User user = users.where().equalTo("name","Edwon").findFirst();
//        Log.e("MYLogUser",user+"");



//        RealmResults<User> users = realm.where(User.class).between("edad",0,30).equalTo("name","Sergio").findAll();
//        RealmResults<User> users = realm.where(User.class).in("name", new String[]{"Edwin", "Sergio"}).findAll();
//        RealmResults<User> users = realm.where(User.class).like("name","¿dw*").findAll();
//        RealmResults<User> users = realm.where(User.class).distinct("edad");


        return users;

    }

    //Actulizar nombre del usuario
    public void actualizauser(User user,String name){
        realm.beginTransaction();
        user.setName(name);
        realm.commitTransaction();
    }

    //Insertar usuario
    public void insertUser(int id, String name, String email, boolean option,int edad){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setOption(option);
        user.setEdad(edad);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

    }

    //Borrar usuario por ID
    public void borrarUser(int id){
        User user = obtenerUsuarioId(id);
        realm.beginTransaction();
        user.deleteFromRealm();
        realm.commitTransaction();
    }

    //ObtenerCurso
    public RealmResults<Curso> obtenerCursos(){
        RealmResults<Curso> cursoRealmResults = realm.where(Curso.class).findAll();
        return cursoRealmResults;
    }


    //Obtener curso por id
    public Curso obtenerCurseID(int id){
        Curso curso = realm.where(Curso.class).equalTo("id",id).findFirst();
        return curso;
    }

    //Insertar nuevo curso
    public void insertarCurso(int id, String name){

        RealmResults<User> lista = obtenerUsuarios();
        RealmList<User> results = new RealmList<>();
        results.addAll(lista.subList(0,lista.size()));

        Curso curso = new Curso(id,name,results);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(curso);
        realm.commitTransaction();
    }

}
