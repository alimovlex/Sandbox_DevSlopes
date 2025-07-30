package com.example.linseb325.devslopesradio.Adapters;

import androidx.recyclerview.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linseb325.devslopesradio.Activities.MainActivity;
import com.example.linseb325.devslopesradio.Model.Station;

import java.util.ArrayList;

import com.example.linseb325.devslopesradio.R;
import com.example.linseb325.devslopesradio.ViewHolders.StationViewHolder;

/**
 * Created by linseb325 on 1/10/18.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationViewHolder> {

    // The radio stations this adapter will manage.
    private ArrayList<Station> stations;

    // Constructor
    public StationsAdapter(ArrayList<Station> stations) {
        this.stations = stations;
    }


    // Called when we pass the data into the view holder
    @Override
    public void onBindViewHolder(StationViewHolder holder, final int position) {
        holder.updateUI(stations.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When a station is tapped, load the details screen.
                MainActivity.getMainActivity().loadStationDetailsScreen(stations.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return stations.size();
    }


    // Creates and returns the view that the ViewHolder will hold.
    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View stationCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_station, parent, false);
        return new StationViewHolder(stationCard);
    }
}
