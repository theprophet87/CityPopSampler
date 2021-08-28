package com.theprophet.topcitypopv2;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_layout);
                if (fragment != null) {
                    // check for fragment and set the drawer state
                    if(fragment instanceof CurrentFragment){
                        // set drawer state for 1
                        toolbar.setTitle(R.string.current_playlist_text);
                    }else if(fragment instanceof PreviousFragment){
                        toolbar.setTitle(R.string.previous_playlist_text);
                    }
                }
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id) {
                    case R.id.nav_current:
                        //switch fragment
                        replaceFragment(new CurrentFragment());
                        //change header
                       toolbar.setTitle(R.string.current_playlist_text);

                        break;
                    case R.id.nav_previous:
                        //switch fragment
                        replaceFragment(new PreviousFragment());
                        //change header
                       toolbar.setTitle(R.string.previous_playlist_text);

                        break;
                    case R.id.nav_contact:
                        //switch fragment
                        replaceFragment(new ContactFragment());
                        //change header
                       toolbar.setTitle(R.string.contact_us_text);
                        break;
                    case R.id.nav_rate:
                        //switch fragment
                        Toast.makeText(getApplicationContext(), "Give us 5 stars!", Toast.LENGTH_SHORT).show();
                        //change header
                    default:
                        return true;

                }
                return true;
            }
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        //addToBackStack will allow us to go back to previous fragment when 'back' button is pressed
        fragmentTransaction.replace(R.id.frame_layout, fragment).addToBackStack(null).commit();

          }



}