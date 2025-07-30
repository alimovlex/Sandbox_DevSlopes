package com.example.linseb325.devslopesradio.ViewHolders;

//import android.support.v7.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linseb325.devslopesradio.Model.Station;
import com.example.linseb325.devslopesradio.R;

/**
 * Created by linseb325 on 1/10/18.
 */

public class StationViewHolder extends RecyclerView.ViewHolder {

    private ImageView stationImageView;
    private TextView stationTitleTextView;


    // Constructor. Set outlets to the itemView.
    public StationViewHolder(View itemView) {
        super(itemView);

        this.stationImageView = itemView.findViewById(R.id.stationImageView);
        this.stationTitleTextView = itemView.findViewById(R.id.stationTitleTextView);
    }


    // Set the station's image and title in UI.
    public void updateUI(Station station) {
        String uri = station.getImageURI();
        int resourceID = stationImageView.getResources().getIdentifier(uri, null, stationImageView.getContext().getPackageName());
        this.stationImageView.setImageResource(resourceID);

        this.stationTitleTextView.setText(station.getTitle());
    }


}
