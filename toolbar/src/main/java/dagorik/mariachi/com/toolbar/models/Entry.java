package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Entry {
    @SerializedName("time")
    private String time;
    @SerializedName("id")
    private String id;
    @SerializedName("messaging")
    private List<Messaging> messaging;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Messaging> getMessaging() {
        return messaging;
    }

    public void setMessaging(List<Messaging> messaging) {
        this.messaging = messaging;
    }
}
