package pt.whatever.blowout;

import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Event {

    private Integer id;
    private String date;
    private String img;
    private String distance;
    private Drawable imgDrawable;
    private String coordinates;

    public Event(Integer id, String date, String img, String coordinates,String distance) {
        this.id = id;
        this.date = date;
        this.img = img;
        this.coordinates = coordinates;
        this.distance=distance;
        loadImage();
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getImg() {
        return img;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getDistance() {
        return distance;
    }

    public Drawable getImgDrawable() {
        return imgDrawable;
    }

    public void loadImage() {

        InputStream is = null;
        try {
            is = (InputStream) new URL(img).getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgDrawable = Drawable.createFromStream(is, "src name");
    }

}
