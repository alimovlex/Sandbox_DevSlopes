package com.example.linseb325.devslopesradio.Adapters;

//import android.support.v7.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.linseb325.devslopesradio.Model.Playlist;
import com.example.linseb325.devslopesradio.R;
import com.example.linseb325.devslopesradio.ViewHolders.PlaylistViewHolder;

import java.util.ArrayList;

/**
 * Created by linseb325 on 1/14/18.
 */

public class PlaylistsAdapter extends RecyclerView.Adapter<PlaylistViewHolder> {

    private ArrayList<Playlist> playlists;

    public PlaylistsAdapter(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }


    // Updates the UI for the view holder.
    @Override
    public void onBindViewHolder(PlaylistViewHolder holder, int position) {
        holder.updateUI(playlists.get(position));
    }


    @Override
    public int getItemCount() {
        return playlists.size();
    }


    // Returns the view holder to use.
    @Override
    public PlaylistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View playlistCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_playlist, parent, false);
        return new PlaylistViewHolder(playlistCard);
    }


}
