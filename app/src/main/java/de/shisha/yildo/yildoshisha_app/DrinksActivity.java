package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DrinksActivity extends AppCompatActivity {

    private static String LOG_TAG = "Yildo";

    private SqliteHandler db_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db_handler = new SqliteHandler(this, null, null, 1);

        //ArrayList<Getraenk> getraenke_list = db_handler.get_item_list2();


        // Softdrinks
        try {
            ArrayList<Getraenk> getraenke_list = db_handler.get_getraenke_by_typ(getResources().getString(R.string.typ_softgetraenke));
            Log.d(LOG_TAG, "soft_drinks: list=" + getraenke_list.size());

            ListView drinks_lv = (ListView) findViewById(R.id.soft_drinks_lv);
            drinks_lv.setDivider(null);
            drinks_lv.setDividerHeight(0);

            drinks_lv.setAdapter(new CustomDrinksAdapter(this, getraenke_list));
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at setting adapter for typ_softgetraenke:\n" + e.toString());
        }


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
