package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetraenkeActivity extends AppCompatActivity {

    private static String LOG_TAG = "Yildo";

    Button add_button;
    Button show_button;
    Button clear_button;
    TextView show_db;
    SqliteHandler db_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getraenke);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add_button = (Button) findViewById(R.id.db_add);
        show_button = (Button) findViewById(R.id.db_show);
        clear_button = (Button) findViewById(R.id.db_clear);
        show_db = (TextView) findViewById(R.id.db_tv);

        Log.e(LOG_TAG, "initialized");

        try {
            db_handler = new SqliteHandler(this, null, null, 1);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception caught at opening new GetraenkeActivity#db_handler");
            Log.e(LOG_TAG, e.toString());
        }

        Log.e(LOG_TAG, "db handler initialized");

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db_handler.add_getraenk(new Getraenk("Bier", 2.50));
                    db_handler.add_getraenk(new Getraenk("Wasser", 2.20));
                    db_handler.add_getraenk(new Getraenk("Kaffee", 2.80));
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#fill_db");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.e(LOG_TAG, "add_button finished");
            }
        });

        Log.e(LOG_TAG, "add_button initalized");

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db_handler.clear_table();
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#clear_table");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.e(LOG_TAG, "clear_button finished");
            }
        });

        Log.e(LOG_TAG, "clear_button initalized");


        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    String db_string = db_handler.database_to_string();
//                    show_db.setText(db_string);
                    Log.e(LOG_TAG, "count=" + db_handler.get_item_list().size());
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#show_button");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.e(LOG_TAG, "show_db finished");
            }
        });

        Log.e(LOG_TAG, "show_db initalized");
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
