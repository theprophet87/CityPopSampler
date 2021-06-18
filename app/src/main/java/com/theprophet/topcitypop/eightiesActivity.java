package com.theprophet.topcitypop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class eightiesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eighties_activity);


        //set view for recycler view
        RecyclerView list = findViewById(R.id.recycler_view_projects);

        //enter song information here
        Songs[] songs = {
                new Songs("Love Trip", "Takako Mamiya", R.drawable.love_trip),
                new Songs("First Light", "Makoto Matsushita", R.drawable.first_light),
                new Songs("Living In the City", "Judy Anton", R.drawable.living_in_the_city),
                new Songs("Tasogare", "Mai Yamane", R.drawable.tasogare),
                new Songs("Slow Nights", "Tomoko Aran", R.drawable.slow_nights),
        };

        String[] urls = {"https://www.youtube.com/watch?v=isfBNsyIgGg",
                "https://www.youtube.com/watch?v=4ESWmrPmJA8",
                "https://www.youtube.com/watch?v=kN5sV4TezN0",
                "https://www.youtube.com/watch?v=IhCDK_pSjnk",
                "https://www.youtube.com/watch?v=N7ZYBawyJQ8"

        };
        //create adapter to add songs array
        SongsAdapter adapter = new SongsAdapter(songs, urls);

        //set the adapter
        list.setAdapter(adapter);



    }
}
