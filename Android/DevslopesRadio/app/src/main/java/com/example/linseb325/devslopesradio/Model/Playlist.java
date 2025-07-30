package com.example.linseb325.devslopesradio.Model;

import java.util.ArrayList;

/**
 * Created by linseb325 on 1/12/18.
 */

public class Playlist {

    private final String DRAWABLE = "drawable/";

    private String name;
    private String description;
    private ArrayList<String> imageURIs;


    // Constructor
    public Playlist(String name, String description, ArrayList<String> imageURIs) {
        this.name = name;
        this.description = description;

        ArrayList<String> completedURIs = new ArrayList<>();

        for (String uri : imageURIs) {
            String completedURI = DRAWABLE + uri;
            completedURIs.add(completedURI);
        }

        this.imageURIs = completedURIs;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImageURIs() {
        return imageURIs;
    }
}
