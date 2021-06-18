package com.theprophet.topcitypop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class seventiesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seventies_activity);

        //set view for recycler view
        RecyclerView list = findViewById(R.id.recycler_view_projects);

        //enter song information here
        Songs[] songs = {
                new Songs("Stay With Me", "Miki Matsubara", R.drawable.stay_with_me),
                new Songs("Fuwari Fuwafuwa", "Ruriko Ohgami", R.drawable.fuwari_fuwafuwa),
                new Songs("Highway", "Fujimaru Band", R.drawable.highway),
                new Songs("4 AM", "Taeko Ohnuki", R.drawable.four_am),
                new Songs("Midnight Rendezvous", "Casiopea", R.drawable.midnight_rendezvous),
        };

        String[] urls = {"https://www.youtube.com/watch?v=VEe_yIbW64w",
                "https://www.youtube.com/watch?v=Rl3FNIczgfs",
                "https://www.youtube.com/watch?v=Z0lRPJJ59Ds",
                "https://www.youtube.com/watch?v=4tEXaW8tPso",
                "https://www.youtube.com/watch?v=inwk2RlXUzw"

        };

        //create adapter to add songs array
        SongsAdapter adapter = new SongsAdapter(songs, urls);

        //set the adapter
        list.setAdapter(adapter);


    }
}
