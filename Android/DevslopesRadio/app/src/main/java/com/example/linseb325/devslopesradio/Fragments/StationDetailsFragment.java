package com.example.linseb325.devslopesradio.Fragments;


import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.fragment.app.Fragment;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linseb325.devslopesradio.Adapters.PlaylistsAdapter;
import com.example.linseb325.devslopesradio.R;
import com.example.linseb325.devslopesradio.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationDetailsFragment extends Fragment {

    private static final String ARG_STATION_NAME = "selectedStationName";

    private String selectedStationName;


    public StationDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param selectedStationName The name of the station we're about to show playlists for.
     * @return A new instance of fragment StationDetailsFragment.
     */

    public static StationDetailsFragment newInstance(String selectedStationName) {
        StationDetailsFragment fragment = new StationDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_STATION_NAME, selectedStationName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.selectedStationName = getArguments().getString(ARG_STATION_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_station_details, container, false);

        // Create and configure the recycler view.
        RecyclerView recyclerView = v.findViewById(R.id.recycler_playlists);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new StationsFragment.HorizontalSpaceItemDecorator(30));


        // A recycler view needs an adapter.
        PlaylistsAdapter adapter = new PlaylistsAdapter(DataService.getInstance().getPlaylistsForStation(this.selectedStationName));
        recyclerView.setAdapter(adapter);


        // A recycler view also needs a layout manager.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);



        return v;
    }

}
