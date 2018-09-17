package com.example.pc.food_encyclopedia;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.pc.food_encyclopedia.fragment.RateReveiwFragment;
import com.example.pc.food_encyclopedia.fragment.RestaurantListFrgament;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(null);
            actionBar.setHomeButtonEnabled(false); // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // remove the icon
        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        launchMainPage();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_rate_review) {
launchReviewPage();
        } else if (id == R.id.nav_location) {

        } else if (id == R.id.nav_fet_details) {

        } else if (id == R.id.nav_your_order) {

        } else if (id == R.id.nav_saved_items) {

        } else if (id == R.id.nav_sign_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchMainPage() {
        FragmentTransaction transactin = getSupportFragmentManager().beginTransaction();
        RestaurantListFrgament restaurantListFrgament = new RestaurantListFrgament();
        transactin.add(R.id.fragment_base, restaurantListFrgament);
        transactin.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        //transactin.addToBackStack(null);
        transactin.commit();

    }

    private void launchReviewPage() {
        FragmentTransaction transactin = getSupportFragmentManager().beginTransaction();
        RateReveiwFragment rateReveiwFragment = new RateReveiwFragment();
        transactin.replace(R.id.fragment_base, rateReveiwFragment);
        transactin.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transactin.addToBackStack(null);
        transactin.commit();

    }

}
