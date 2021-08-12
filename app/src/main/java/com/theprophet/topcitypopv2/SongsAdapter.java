package com.theprophet.topcitypopv2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.theprophet.topcitypopv2.R;
import com.theprophet.topcitypopv2.Songs;


public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

    private Songs[] songs;
    private String[] urls;
    private int pos;
    private onItemClickListener mOnItemClickListener;

    public SongsAdapter(Songs[] songs, String[] urls, onItemClickListener onItemClickListener){
        this.songs = songs;
        this.urls = urls;
        this.mOnItemClickListener = onItemClickListener;

    }

    @Override
    public int getItemCount() {
        return songs.length;
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new SongsViewHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        holder.bind(songs[holder.getBindingAdapterPosition()]);
        holder.itemView.setOnClickListener(view ->{
            mOnItemClickListener.onItemClick(holder.getBindingAdapterPosition());

        });
    }



    static class SongsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView songImage;
        private TextView songTitle;
        private TextView songArtist;
        onItemClickListener onItemClickListener;

        public SongsViewHolder(@NonNull View itemView, onItemClickListener onItemClickListener) {
            super(itemView);

            //create views for song attributes so they can show up in the item list
            songImage = itemView.findViewById(R.id.image_view_project_icon);
            songTitle = itemView.findViewById(R.id.image_view_project_title);
            songArtist = itemView.findViewById(R.id.text_view_artist_name);
            this.onItemClickListener = onItemClickListener;

            itemView.setOnClickListener(this);
        }

        //this method will allow the text for the song attributes to appear in our activity
        public void bind(Songs songs){

            songTitle.setText(songs.title);
            songArtist.setText(songs.artist);
            songImage.setImageResource(songs.image);
        }

        @Override
        public void onClick(View v) { //this method will get the position of the item in the recyclerview
                                    // it will let the program know which item we selected so it can be used to change videos
            onItemClickListener.onItemClick(getBindingAdapterPosition());
        }
    }



}
