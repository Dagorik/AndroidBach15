package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Dagorik on 21/08/17.
 */

public class Model {


    @SerializedName("entry")
    private List<Entry> entry;
    @SerializedName("object")
    private String object;

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
