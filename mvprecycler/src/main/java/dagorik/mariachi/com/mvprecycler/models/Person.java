package dagorik.mariachi.com.mvprecycler.models;

/**
 * Created by Dagorik on 11/08/17.
 */

public class Person {


    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    String name;

    String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
