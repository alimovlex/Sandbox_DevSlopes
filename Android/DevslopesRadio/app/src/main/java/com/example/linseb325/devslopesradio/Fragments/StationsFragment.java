package com.example.linseb325.devslopesradio.Fragments;


import android.graphics.Rect;
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

import com.example.linseb325.devslopesradio.Adapters.StationsAdapter;
import com.example.linseb325.devslopesradio.Model.Station;
import com.example.linseb325.devslopesradio.R;
import com.example.linseb325.devslopesradio.Services.DataService;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StationsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationsFragment extends Fragment {

    // Key for getting the stationType argument from the 'args' bundle.
    private static final String ARG_STATION_TYPE = "station_type";

    // Three types of radio stations.
    // We pass a station type into the StationsFragment when we create a new instance.
    // Later, we use it to discern which type of station data to request from the DataService.
    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

    private int stationType;


    // Constructor
    public StationsFragment() {}

    // Another constructor
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType The radio stations' category. May be featured, recent, or party.
     * @return A new instance of fragment StationsFragment.
     */
    public static StationsFragment newInstance(int stationType) {
        StationsFragment fragment = new StationsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stations, container, false);


        // Creating and configuring the recycler view
        RecyclerView recyclerView = v.findViewById(R.id.recycler_stations);
        recyclerView.setHasFixedSize(true);     // Gives us some optimizations
        recyclerView.addItemDecoration(new HorizontalSpaceItemDecorator(30));   // Spacing between station icons


        // A recycler view needs an adapter
        StationsAdapter adapter;

        switch (this.stationType) {
            case STATION_TYPE_FEATURED:
                adapter = new StationsAdapter(DataService.getInstance().getFeaturedStations());
                break;
            case STATION_TYPE_RECENT:
                adapter = new StationsAdapter(DataService.getInstance().getRecentStations());
                break;
            case STATION_TYPE_PARTY:
                adapter = new StationsAdapter(DataService.getInstance().getPartyStations());
                break;
            default:
                adapter = new StationsAdapter(new ArrayList<Station>());
                break;
        }

        recyclerView.setAdapter(adapter);


        // A recycler view needs a layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(layoutManager);


        return v;
    }



    // For adding space between station icons
    public static class HorizontalSpaceItemDecorator extends RecyclerView.ItemDecoration {

        private final int spacer;

        public HorizontalSpaceItemDecorator(int spacer) {
            this.spacer = spacer;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.right = spacer;
            outRect.left = spacer;
            outRect.bottom = spacer;
            outRect.top = spacer;
        }
    }








}


