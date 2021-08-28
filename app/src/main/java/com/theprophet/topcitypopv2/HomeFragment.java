package com.theprophet.topcitypopv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class HomeFragment extends Fragment {
    View root;

    RecyclerView list;
    YouTubePlayerView youTubePlayerView;



    private int pos; //this variable will hold the position of the song cards in the RecyclerView
    Songs[] songs = {
            new Songs("Love Trip", "Takako Mamiya", R.drawable.love_trip, 0),
            new Songs("First Light", "Makoto Matsushita", R.drawable.first_light, 1),
            new Songs("Living In the City", "Judy Anton", R.drawable.living_in_the_city, 2),
            new Songs("Tasogare", "Mai Yamane", R.drawable.tasogare, 3),
            new Songs("Slow Nights", "Tomoko Aran", R.drawable.slow_nights, 4)
    };

    //video IDs
    String[] urls = {"isfBNsyIgGg",
            "4ESWmrPmJA8",
            "kN5sV4TezN0",
            "IhCDK_pSjnk",
            "N7ZYBawyJQ8"
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);

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


    private void onRecyclerViewClick(YouTubePlayer youTubePlayer) {
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