package com.example.prakash.apartment.activity;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.example.prakash.apartment.R;
import com.example.prakash.apartment.fragment.Apartments;
import com.example.prakash.apartment.fragment.Contact_us;
import com.example.prakash.apartment.fragment.Dashboard;
import com.example.prakash.apartment.fragment.Gallery;
import com.example.prakash.apartment.fragment.Location;

import static com.example.prakash.apartment.R.id.toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);








        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.setScrimColor(getResources().getColor(android.R.color.transparent));
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





FragmentManager fragmentmanager=getSupportFragmentManager();

        FragmentTransaction fragmenttranscation=fragmentmanager.beginTransaction();
 Dashboard dashboard=new Dashboard();
        fragmenttranscation.replace(R.id.mainFragment, dashboard);
        fragmenttranscation.commit();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
            } else if (!doubleBackToExitPressedOnce) {
                this.doubleBackToExitPressedOnce = true;


                FrameLayout frameLayout=(FrameLayout)findViewById(R.id.mainFragment);

                Snackbar snackbar = Snackbar
                        .make(frameLayout, "Please click BACK again to exit.", Snackbar.LENGTH_LONG);


                View snackBarView = snackbar.getView();
                snackBarView.setBackgroundColor(Color.BLUE);
                TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();


                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            } else {
                super.onBackPressed();

            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        // Handle navigation view item clicks here.


        FragmentManager fragmentManager = getSupportFragmentManager();

        //middle man
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            toolbar.setTitle("Home");
            setSupportActionBar(toolbar);
            Dashboard fragmentDashboard = new Dashboard();
            fragmentTransaction.replace(R.id.mainFragment, fragmentDashboard);
            fragmentTransaction.addToBackStack(null);




        } else if (id == R.id.nav_apartment) {
            toolbar.setTitle("Apartment");
            setSupportActionBar(toolbar);
            Apartments apartment = new Apartments();
            fragmentTransaction.replace(R.id.mainFragment, apartment);
            fragmentTransaction.addToBackStack("Home");

        }else if (id == R.id.nav_aboutus) {

            toolbar.setTitle("About us");
            setSupportActionBar(toolbar);
            Location location=new Location();
            fragmentTransaction.replace(R.id.mainFragment, location);
            fragmentTransaction.addToBackStack("home");

        }
        else if (id == R.id.nav_gallery) {

            toolbar.setTitle("Gallery");
            setSupportActionBar(toolbar);
        Gallery gallery=new Gallery();
            fragmentTransaction.replace(R.id.mainFragment, gallery);
            fragmentTransaction.addToBackStack("home");

        }
        else if (id == R.id.nav_locaiton) {

            toolbar.setTitle("Location");
            setSupportActionBar(toolbar);
            Location location=new Location();
            fragmentTransaction.replace(R.id.mainFragment, location);
            fragmentTransaction.addToBackStack("home");

        } else if (id == R.id.nav_contactus) {
            toolbar.setTitle("Contact");
            setSupportActionBar(toolbar);
            Contact_us contact=new Contact_us();
            fragmentTransaction.replace(R.id.mainFragment, contact);
            fragmentTransaction.addToBackStack("home");

        }
        else if (id==R.id.nav_travels)
        {

        }
        else if (id == R.id.nav_feedback) {

        } else if (id == R.id.nav_send) {

        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragmentTransaction.commit();
        return true;
    }





}
