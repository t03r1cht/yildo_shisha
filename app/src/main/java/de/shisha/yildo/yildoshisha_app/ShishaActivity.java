package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShishaActivity extends AppCompatActivity {

    private static String LOG_TAG = "Yildo";

    private SqliteHandler db_handler;

    List<String> listDataHeader;
    HashMap<String, List<Product>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shisha);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db_handler = new SqliteHandler(this, null, null, 1);

        try {

            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<Product>>();

            // 7Days
            listDataHeader.add(getResources().getString(R.string.section_7days));
            List<Product> seven_days_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_7days));

            // Adalya
            listDataHeader.add(getResources().getString(R.string.section_adalya));
            List<Product> adalya_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_adalya));

            // Al Waha
            listDataHeader.add(getResources().getString(R.string.section_al_waha));
            List<Product> al_waha_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_al_waha));

            // Al Fakher
            listDataHeader.add(getResources().getString(R.string.section_al_fakher));
            List<Product> al_fakher_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_al_fakher));

            // Chillma
            listDataHeader.add(getResources().getString(R.string.section_chillma));
            List<Product> chillma_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_chillma));

            // Chaos
            listDataHeader.add(getResources().getString(R.string.section_chaos));
            List<Product> chaos_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_chaos));

            // Yildo
            listDataHeader.add(getResources().getString(R.string.section_yildo));
            List<Product> yildo_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_yildo));

            // Maridan Tobacco
            listDataHeader.add(getResources().getString(R.string.section_maridan_tobacco));
            List<Product> maridan_tobacco_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_maridan_tobacco));

            // Hasso
            listDataHeader.add(getResources().getString(R.string.section_hasso));
            List<Product> hasso_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_hasso));

            // Social Smoke
            listDataHeader.add(getResources().getString(R.string.section_social_smoke));
            List<Product> social_smoke_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_social_smoke));

            // Oscar
            listDataHeader.add(getResources().getString(R.string.section_oscar));
            List<Product> oscar_shisha_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_oscar));


            listDataChild.put(listDataHeader.get(0), seven_days_shisha_list);
            listDataChild.put(listDataHeader.get(1), adalya_shisha_list);
            listDataChild.put(listDataHeader.get(2), al_waha_shisha_list);
            listDataChild.put(listDataHeader.get(3), al_fakher_shisha_list);
            listDataChild.put(listDataHeader.get(4), chillma_shisha_list);
            listDataChild.put(listDataHeader.get(5), chaos_shisha_list);
            listDataChild.put(listDataHeader.get(6), yildo_shisha_list);
            listDataChild.put(listDataHeader.get(7), maridan_tobacco_shisha_list);
            listDataChild.put(listDataHeader.get(8), hasso_shisha_list);
            listDataChild.put(listDataHeader.get(9), social_smoke_shisha_list);
            listDataChild.put(listDataHeader.get(10), oscar_shisha_list);


            ExpandableListView exp_lv = (ExpandableListView) findViewById(R.id.lvExpShishas);
            exp_lv.setDivider(null);
            exp_lv.setDividerHeight(0);
            exp_lv.setAdapter(new CustomExpandableAdapterDrinks(this, listDataHeader, listDataChild));
            for (int i = 0; i < 11; i++) {
                exp_lv.expandGroup(i);
            }


        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at setting adapter for typ_softgetraenke:\n" + e.toString());
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
