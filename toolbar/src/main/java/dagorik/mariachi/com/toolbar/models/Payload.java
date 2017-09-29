package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

public class Payload {
    @SerializedName("coordinates")
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
