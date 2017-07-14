package dagorik.mariachi.com.realmdatabase.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dagorik on 13/07/17.
 */

public class Curso extends RealmObject {

    @PrimaryKey
    private int idCuso;

    private String nameCurso;

    private RealmList<User> users;

    public Curso(int idCuso, String nameCurso, RealmList<User> users) {
        this.idCuso = idCuso;
        this.nameCurso = nameCurso;
        this.users = users;
    }

    public Curso() {
    }

    public int getIdCuso() {
        return idCuso;
    }

    public void setIdCuso(int idCuso) {
        this.idCuso = idCuso;
    }

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public RealmList<User> getUsers() {
        return users;
    }

    public void setUsers(RealmList<User> users) {
        this.users = users;
    }
}
