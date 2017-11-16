package de.shisha.yildo.yildoshisha_app;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static String LOG_TAG = "Yildo";

    // Drawer Listener
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView nav_view;

    // Drawer Header
    TextView nav_header_tv;
    Typeface tf_raleway;
    Typeface tf_greatvibes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Configure navigation bar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Set text
        this.nav_view = (NavigationView) findViewById(R.id.nav_view_home);
        nav_header_tv = (TextView) nav_view.getHeaderView(0).findViewById(R.id.nav_header_tv);

        // Register NavigationView.OnNavigationItemSelectedListener
        setNavigationViewListener();
        // Set custom font
        try {
            tf_raleway = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
            nav_header_tv.setTypeface(tf_raleway);

            tf_greatvibes = Typeface.createFromAsset(getAssets(), "fonts/GreatVibes-Regular.ttf");
            ((TextView) findViewById(R.id.main_logo_tv)).setTypeface(tf_greatvibes);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Caught error when trying to set new font:");
            Log.e(LOG_TAG, e.toString());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if(id == R.id.nav_home) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.e(LOG_TAG, "Clicked nav_home");
            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            this.startActivity(intent);
            Log.e(LOG_TAG, "Switched to intent 'HomeActivity'");
        } else if(id == R.id.nav_aboutUs) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.e(LOG_TAG, "Clicked nav_aboutUs");

            try {
                Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'AboutUsActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if(id == R.id.nav_drinks) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.e(LOG_TAG, "Clicked nav_drinks");

            try {
                Intent intent = new Intent(HomeActivity.this, GetraenkeActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'GetraenkeActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if(id == R.id.nav_exit) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.e(LOG_TAG, "Clicked nav_exit");
            finish();
            System.exit(0);
        }
        return true;
    }

    private void setNavigationViewListener() {
        try {
            this.nav_view.setNavigationItemSelectedListener(this);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at setNavigationViewListener");
        }
    }

    private void uncheckNavigationDrawer() {
        int size = nav_view.getMenu().size();
        for(int i = 0; i < size; i++) {
            nav_view.getMenu().getItem(i).setChecked(false);
        }
    }
}
