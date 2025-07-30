package com.example.linseb325.devslopesradio.Model;

/**
 * Created by linseb325 on 1/11/18.
 */

public class Station {

    final String DRAWABLE = "drawable/";
    private String title;
    private String imageURI;

    public Station(String title, String imageURI) {
        this.title = title;
        this.imageURI = imageURI;
    }


    public String getTitle() {
        return title;
    }

    public String getImageURI() {
        return DRAWABLE + imageURI;
    }
}
