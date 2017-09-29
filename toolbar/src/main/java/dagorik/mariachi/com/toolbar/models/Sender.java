package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

public class Sender {
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
