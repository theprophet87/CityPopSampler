package com.theprophet.topcitypopv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class PreviousFragment extends Fragment {
    View root;
    RecyclerView list;
    YouTubePlayerView youTubePlayerView;


    private int pos; //this variable will hold the position of the song cards in the RecyclerView
    Songs[] songs = {
            new Songs("In the City Night", "AB's", R.drawable.in_the_city_night, 0),
            new Songs("Stay With Me", "Miki Matsubara", R.drawable.stay_with_me, 1),
            new Songs("Ramen Tabetai", "Akiko Yano", R.drawable.ramen_tabetai, 2),
            new Songs("Lonely Feeling", "Eri Kojima", R.drawable.lonely_feeling_jpeg, 3),
            new Songs("Mariko", "Yukari Ito", R.drawable.mariko, 4)
    };

    //video IDs
    String[] urls = {"5tQ4TG2upp0",
            "VEe_yIbW64w",
            "eNwZVRBJy58",
            "g1kQ7O9H6bA",
            "DZmIwWzwJ-g"
    };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_previous, container, false);
        youTubePlayerView = root.findViewById(R.id.youtube_player_view);




        initYoutubePlayerView();



        // Inflate the layout for this fragment
        return root;
    }

    private void initYoutubePlayerView() {
        //set view for recycler view
        list = root.findViewById(R.id.recycler_view_projects);




        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                //create adapter to add songs array
                SongsAdapter adapter = new SongsAdapter(songs, urls, new SongsAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        pos = position; //takes in the position of the item in the RecyclerView
                        youTubePlayer.loadVideo(urls[pos], 0f);

                    }
                });
                //set the adapter
                list.setAdapter(adapter);


            }

        });
    }


private void recyclerViewSetup(YouTubePlayer youTubePlayer){
    //set view for recycler view
    list = root.findViewById(R.id.recycler_view_projects);


    //create adapter to add songs array
    SongsAdapter adapter = new SongsAdapter(songs, urls, new SongsAdapter.onItemClickListener() {
        @Override
        public void onItemClick(int position) {
            pos = position; //takes in the position of the item in the RecyclerView
            youTubePlayer.loadVideo(urls[pos], 0f);

        }
    });

    //set the adapter
    list.setAdapter(adapter);

        }

}