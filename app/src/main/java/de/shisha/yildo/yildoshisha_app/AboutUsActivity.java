package de.shisha.yildo.yildoshisha_app;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutUsActivity extends AppCompatActivity {

    private static String LOG_TAG = "Yildo";

    // Content text
    Typeface tf_raleway;
    TextView title_tv;

    // Drawer Listener
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        title_tv = (TextView) findViewById(R.id.about_us_title);
        TextView about_us_content = (TextView) findViewById(R.id.about_us_content);

        try {
            tf_raleway = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
            title_tv.setTypeface(tf_raleway);
            about_us_content.setTypeface(tf_raleway);

        } catch (Exception e) {
            Log.e(LOG_TAG, "Caught error when trying to set new font:");
            Log.e(LOG_TAG, e.toString());
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}
