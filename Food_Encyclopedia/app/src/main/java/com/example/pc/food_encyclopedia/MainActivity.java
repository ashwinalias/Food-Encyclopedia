package com.example.pc.food_encyclopedia;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.pc.food_encyclopedia.constants.Constants;
import com.example.pc.food_encyclopedia.fragment.RateReveiwFragment;
import com.example.pc.food_encyclopedia.fragment.RestaurantListFrgament;
import com.example.pc.food_encyclopedia.listeners.OnFragmentActions;
import com.example.pc.food_encyclopedia.util.TypeUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener,OnFragmentActions {
    private Button mBackButton, mMenuButton;
    private DrawerLayout mDrawer;
    private TextView mTitle,footerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.toolbar_bg));
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mBackButton = toolbar.findViewById(R.id.back_button);
        mMenuButton = toolbar.findViewById(R.id.menu_button);
        mTitle = toolbar.findViewById(R.id.title);
        footerTextView = findViewById(R.id.footer_text);
        TypeUtils.setBaseFontviews(this,mTitle);
        TypeUtils.setBaseFontviews(this,footerTextView);
        setFooterTitle();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
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
        mBackButton.setOnClickListener(this);
        mMenuButton.setOnClickListener(this);
        launchMainPage();
    }

    private void setFooterTitle() {
        String sampleText = "<font color='"+ Constants.ColorConstants.WHITE+"'>FOOD </font><font color='"+Constants.ColorConstants.APP_GREEN_COLOR+"'>ENCYCLOPEIDA</font>";
        footerTextView.setText(Html.fromHtml(sampleText), TextView.BufferType.SPANNABLE);
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
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

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.back_button) {
            onBackPressed();
        } else if (view.getId() == R.id.menu_button) {
            if (mDrawer != null) {
                if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                    mDrawer.closeDrawer(GravityCompat.START);
                } else {
                    mDrawer.openDrawer(GravityCompat.START);
                }
            }
        }
    }

    @Override
    public void onChangeTitle(String title, String scondaryTitle) {

    }
}