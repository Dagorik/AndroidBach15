package dagorik.mariachi.com.retrofitexamplemodels.models.modeloEjemplo;

/**
 * Created by Dagorik on 28/07/17.
 */

public class Contactos {

    String id;

    String name;

    Phone phoner;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhoner() {
        return phoner;
    }

    public void setPhoner(Phone phoner) {
        this.phoner = phoner;
    }
}
