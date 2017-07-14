package dagorik.mariachi.com.realmdatabase.servicesRealm;

import dagorik.mariachi.com.realmdatabase.models.Curso;
import dagorik.mariachi.com.realmdatabase.models.User;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

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

    //Actulizar nombre del usuario
    public void actualizauser(User user,String name){
        realm.beginTransaction();
        user.setName(name);
        realm.commitTransaction();
    }

    //Insertar usuario
    public void insertUser(int id, String name, String email, boolean option){
        realm.beginTransaction();
        User user = realm.createObject(User.class,id);
        user.setName(name);
        user.setEmail(email);
        user.setOption(option);
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
