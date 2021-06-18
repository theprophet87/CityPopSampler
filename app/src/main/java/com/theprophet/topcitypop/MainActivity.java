package com.theprophet.topcitypop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView seventiesButton;
    private ImageView eightiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seventiesButton = findViewById(R.id.seventies_icon);
        eightiesButton = findViewById(R.id.eighties_icon);


        setupOnClickListener70();
        setupOnClickListener80();

    }

    //make buttons clickable
        private void setupOnClickListener70(){

            seventiesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //go to new activity
                    Intent seventiesActivityIntent = new Intent(MainActivity.this, seventiesActivity.class);

                    startActivity(seventiesActivityIntent);

                }
            });

        }

    private void setupOnClickListener80(){

        eightiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eightiesActivityIntent = new Intent(MainActivity.this, eightiesActivity.class);

                startActivity(eightiesActivityIntent);
            }
        });

    }
}