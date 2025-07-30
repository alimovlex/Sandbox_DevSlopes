package com.example.linseb325.devslopesradio.Services;

import android.media.Image;

import com.example.linseb325.devslopesradio.Model.Playlist;
import com.example.linseb325.devslopesradio.Model.Station;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by linseb325 on 1/11/18.
 */

public class DataService {

    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    public static final String TRAVEL_STATION_NAME = "Flight Plan (Tunes for Travel)";
    public static final String BIKING_STATION_NAME = "Two-Wheelin' (Biking Playlist)";
    public static final String KIDS_STATION_NAME = "Kids Jams (Music for Children)";

    // Constructor
    private DataService() {
    }

    // These three methods simulate downloading radio station data from the Internet.
    public ArrayList<Station> getFeaturedStations() {
        ArrayList<Station> stations = new ArrayList<>();

        stations.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        stations.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        stations.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));

        return stations;
    }

    public ArrayList<Station> getRecentStations() {
        ArrayList<Station> stations = new ArrayList<>();

        stations.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));
        stations.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        stations.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));

        return stations;
    }

    public ArrayList<Station> getPartyStations() {
        ArrayList<Station> stations = new ArrayList<>();

        stations.add(new Station("Kids Jams (Music for Children)", "kidsmusic"));
        stations.add(new Station("Flight Plan (Tunes for Travel)", "flightplanmusic"));
        stations.add(new Station("Two-Wheelin' (Biking Playlist)", "bicyclemusic"));

        return stations;
    }


    public ArrayList<Playlist> getPlaylistsForStation(String stationName) {

        // Lists for image URIs. One set of images for each playlist.
        ArrayList<String> travelImageURIs = new ArrayList<>();
        ArrayList<String> bikingImageURIs = new ArrayList<>();
        ArrayList<String> kidsImageURIs = new ArrayList<>();

        // Fill the lists.
        for (int i = 0; i < 6; i++) {
            travelImageURIs.add("flightplanmusic");
            bikingImageURIs.add("bicyclemusic");
            kidsImageURIs.add("kidsmusic");
        }

        Playlist travelPlaylist = new Playlist("International Playlist", "Travel to all seven continents with this eclectic mix of tunes", travelImageURIs);
        Playlist bikingPlaylist = new Playlist("Daredevil Playlist", "Pop a wheelie. Live on the edge. All bangerz.", bikingImageURIs);
        Playlist kidsPlaylist = new Playlist("Little Tykes Playlist", "From Barney to Teletubbies, all of your favorite childhood jams", kidsImageURIs);

        ArrayList<Playlist> playlists = new ArrayList<>();

        switch (stationName) {
            case TRAVEL_STATION_NAME:
                playlists.add(travelPlaylist);
                playlists.add(bikingPlaylist);
                playlists.add(kidsPlaylist);
                break;
            case BIKING_STATION_NAME:
                playlists.add(bikingPlaylist);
                playlists.add(travelPlaylist);
                playlists.add(kidsPlaylist);
                break;
            case KIDS_STATION_NAME:
                playlists.add(kidsPlaylist);
                playlists.add(travelPlaylist);
                playlists.add(bikingPlaylist);
                break;
        }

        return playlists;
    }





}
