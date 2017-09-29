package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

public class Attachments {
    @SerializedName("title")
    private String title;
    @SerializedName("payload")
    private Payload payload;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
