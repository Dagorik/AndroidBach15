package dagorik.mariachi.com.toolbar.models;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lat")
    private double lat;
    @SerializedName("long")
    private double mlong;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getMlong() {
        return mlong;
    }

    public void setMlong(double mlong) {
        this.mlong = mlong;
    }
}
