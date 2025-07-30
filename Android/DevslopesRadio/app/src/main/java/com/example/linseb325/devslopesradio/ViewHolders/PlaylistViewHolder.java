package com.example.linseb325.devslopesradio.ViewHolders;

//import android.support.v7.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linseb325.devslopesradio.Model.Playlist;
import com.example.linseb325.devslopesradio.R;

import java.util.ArrayList;

/**
 * Created by linseb325 on 1/14/18.
 */

public class PlaylistViewHolder extends RecyclerView.ViewHolder {

    private ImageView[] imageViews;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private TextView playlistTitleTextView;
    private TextView playlistDescriptionTextView;


    // Constructor. Set outlets to the itemView.
    public PlaylistViewHolder(View itemView) {
        super(itemView);

        this.imageView1 = itemView.findViewById(R.id.imageView1);
        this.imageView2 = itemView.findViewById(R.id.imageView2);
        this.imageView3 = itemView.findViewById(R.id.imageView3);
        this.imageView4 = itemView.findViewById(R.id.imageView4);
        this.imageView5 = itemView.findViewById(R.id.imageView5);
        this.imageView6 = itemView.findViewById(R.id.imageView6);

        this.imageViews = new ImageView[] {imageView1, imageView2, imageView3, imageView4, imageView5, imageView6};

        this.playlistTitleTextView = itemView.findViewById(R.id.playlistTitleTextView);
        this.playlistDescriptionTextView = itemView.findViewById(R.id.playlistDescriptionTextView);
    }


    // Set the playlist's images/title/description in UI.
    public void updateUI(Playlist playlist) {

        this.playlistTitleTextView.setText(playlist.getName());
        this.playlistDescriptionTextView.setText(playlist.getDescription());

        ArrayList<String> imageURIs = playlist.getImageURIs();

        int currIndex = 0;
        for (String uri : imageURIs) {
            ImageView currImageView = imageViews[currIndex];
            int resourceID = currImageView.getResources().getIdentifier(uri, null, currImageView.getContext().getPackageName());
            currImageView.setImageResource(resourceID);
            currIndex++;
        }
    }


}
