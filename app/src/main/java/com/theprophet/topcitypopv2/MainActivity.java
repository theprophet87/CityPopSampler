package com.theprophet.topcitypopv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    private String API_KEY = "AIzaSyAmF3YBpa-3ECYAhK5QJs6ze27u1fwgagk";
    private int pos;

    //Creates a youtube player to play video when new video selected
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    private YouTubePlayer mYoutubePlayer;

    //enter song information here
    Songs[] songs = {
            new Songs("Love Trip", "Takako Mamiya", R.drawable.love_trip, 0),
            new Songs("First Light", "Makoto Matsushita", R.drawable.first_light, 1),
            new Songs("Living In the City", "Judy Anton", R.drawable.living_in_the_city, 2),
            new Songs("Tasogare", "Mai Yamane", R.drawable.tasogare, 3),
            new Songs("Slow Nights", "Tomoko Aran", R.drawable.slow_nights, 4)
    };

    String[] urls = {"isfBNsyIgGg",
            "4ESWmrPmJA8",
            "kN5sV4TezN0",
            "IhCDK_pSjnk",
            "N7ZYBawyJQ8"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildRecyclerView();
        youTubePlayerSetup();







    }

    private void youTubePlayerSetup() {
        youTubePlayerView = findViewById(R.id.youtube_view);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d("Tag", "onClick: Done initializing.");
                if(!b) {
                    mYoutubePlayer = youTubePlayer;
                    youTubePlayer.loadVideo(urls[pos]);
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.d("Tag", "onClick: Failed to initialize");
            }



        };
        youTubePlayerView.initialize(API_KEY, onInitializedListener);
    }

    private void buildRecyclerView () {

                //set view for recycler view
                RecyclerView list = findViewById(R.id.recycler_view_projects);



                //create adapter to add songs array
                SongsAdapter adapter = new SongsAdapter(songs, urls, new SongsAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        pos = position;
                        Log.d("Tag", "clicked on video " + position+1);

                        mYoutubePlayer.loadVideo(urls[pos]);
                        Log.d("Tag", "onClick: Done initializing.");

                        showToast("You've clicked on video " + pos);
                    }
                });

                //set the adapter
                list.setAdapter(adapter);

                //we need to create a click listener for the adapter/Recyclerview


            }



    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
