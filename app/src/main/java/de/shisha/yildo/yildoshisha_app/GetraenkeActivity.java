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

        try {
            db_handler = new SqliteHandler(this, null, null, 1);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception caught at opening new GetraenkeActivity#db_handler");
            Log.e(LOG_TAG, e.toString());
        }

        Log.d(LOG_TAG, "db handler initialized");

        // Hole Strings
        final String typ_softgetraenke = getResources().getString(R.string.typ_softgetraenke);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_coca_cola), 2.30, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_fanta), 2.30, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_spezi), 2.30, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_sprite), 2.30, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_mineralwasser_klein), 2.30, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_mineralwasser_groß), 3.20, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_red_bull), 3.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_red_bull_zero), 3.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_tonic_water), 2.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_bitter_lemon), 2.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_ginger_ale), 2.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_schweppes_russian_wild_berry), 2.80, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_eistee_pfirsich), 3.50, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_eistee_granatapfel), 3.50, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_eistee_zitrone), 3.50, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_orangina_rot), 2.60, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_orangina_gelb), 2.60, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_moloko), 3.50, typ_softgetraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sof_28black), 4.00, typ_softgetraenke));
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#fill_db");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.d(LOG_TAG, "add_button finished");
            }
        });

        Log.d(LOG_TAG, "add_button initalized");

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    db_handler.clear_table();
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#clear_table");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.d(LOG_TAG, "clear_button finished");
            }
        });

        Log.d(LOG_TAG, "clear_button initalized");


        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    String db_string = db_handler.database_to_string();
//                    show_db.setText(db_string);
                    Log.d(LOG_TAG, "count=" + db_handler.get_item_list().size());
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception caught at GetraenkeActivity#show_button");
                    Log.e(LOG_TAG, e.toString());
                }
                Log.d(LOG_TAG, "show_db finished");
            }
        });

        Log.d(LOG_TAG, "show_db initalized");
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
