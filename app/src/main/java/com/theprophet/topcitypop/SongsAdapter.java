package com.theprophet.topcitypop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

private Songs[] songs;
private String[] urls;

public SongsAdapter(Songs[] songs, String[] urls){
    this.songs = songs;
    this.urls = urls;

}

    @Override
    public int getItemCount() {
        return songs.length;
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);

        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        holder.bind(songs[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               Uri uri = Uri.parse(urls[position]);
               Intent intent = new Intent(Intent.ACTION_VIEW, uri);
               v.getContext().startActivity(intent);


            }
        });
    }



    static class SongsViewHolder extends RecyclerView.ViewHolder{

        private ImageView songImage;
        private TextView songTitle;
        private TextView songArtist;

        public SongsViewHolder(@NonNull View itemView) {
            super(itemView);

            //create views for song attributes so they can show up in the item list
            songImage = itemView.findViewById(R.id.image_view_project_icon);
            songTitle = itemView.findViewById(R.id.image_view_project_title);
            songArtist = itemView.findViewById(R.id.text_view_artist_name);
        }

        //this method will allow the text for the song attributes to appear in our activity
        public void bind(Songs songs){

            songTitle.setText(songs.title);
            songArtist.setText(songs.artist);
            songImage.setImageResource(songs.image);
        }
    }


}
