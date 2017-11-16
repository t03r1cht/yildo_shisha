package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
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

        // Vorbereitung der Daten für ListView und Adapter
//        List<String> getraenke_list = db_handler.get_item_name_list();
//        int item_count = getraenke_list.size();
//        String[] getraenke = new String[item_count];
//
//        getraenke = getraenke_list.toArray(getraenke);
//
//        Log.e(LOG_TAG, "list=" + getraenke_list.size() + " list_string=" + getraenke.length);
//
//        try {
//            ListAdapter g_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getraenke);
//            ListView drinks_lv = (ListView) findViewById(R.id.drinks_lv);
//            drinks_lv.setAdapter(g_adapter);
//        } catch (Exception e) {
//            Log.e(LOG_TAG, "Error at setting adapter:\n" + e.toString());
//        }


        ArrayList<Getraenk> getraenke_list = db_handler.get_item_list2();
        int item_count = getraenke_list.size();

        Log.e(LOG_TAG, "list=" + getraenke_list.size());

        try {
            ListView drinks_lv = (ListView) findViewById(R.id.drinks_lv);
            drinks_lv.setAdapter(new CustomDrinksAdapter(this, getraenke_list));
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at setting adapter:\n" + e.toString());
        }


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
