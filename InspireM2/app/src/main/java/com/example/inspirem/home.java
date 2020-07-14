package com.example.inspirem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.inspirem.ui.dashboard.DashboardFragment;
import com.example.inspirem.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class home extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Home");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    startActivity(new Intent(home.this,home.class));
                    finish();
                    return true;
                case R.id.navigation_search:
                    toolbar.setTitle("Search");
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("Dashboard");
                    fragment = new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle("Notification");
                    fragment = new NotificationsFragment();
                    loadFragment(fragment);
                    return true;

                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    startActivity(new Intent(home.this,profile.class));
                    finish();
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_settings){
            //Toast.makeText(this,"welcome to login",Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getApplicationContext(),profile.class);
            //startActivity(intent);

        }
        if(item.getItemId()==R.id.action_about){
            //Toast.makeText(this,"welcome to login",Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getApplicationContext(),About.class);
            //startActivity(intent);

        }
        if(item.getItemId()==R.id.action_logout){
            //Toast.makeText(this,"you are logouting",Toast.LENGTH_SHORT).show();
            //firebaseAuth.signOut();
            //onStart();
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sidemenu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
