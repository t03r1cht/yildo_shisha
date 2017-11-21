package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrinksActivity extends AppCompatActivity {

    private static String LOG_TAG = "Yildo";

    private SqliteHandler db_handler;

    List<String> listDataHeader;
    HashMap<String, List<Product>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        db_handler = new SqliteHandler(this, null, null, 1);

        try {
//            ArrayList<Product> getraenke_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_softgetraenke));
//            Log.d(LOG_TAG, "soft_drinks: list=" + getraenke_list.size());

//            ListView drinks_lv = (ListView) findViewById(R.id.soft_drinks_lv);
//            drinks_lv.setDivider(null);
//            drinks_lv.setDividerHeight(0);
//
//            drinks_lv.setAdapter(new CustomNewsAdapter(this, getraenke_list));

            listDataHeader = new ArrayList<String>();
            listDataChild = new HashMap<String, List<Product>>();

            // Softdrinks
            listDataHeader.add(getResources().getString(R.string.section_soft_getraenke));
            List<Product> soft_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_softgetraenke));

            // Säfte
            listDataHeader.add(getResources().getString(R.string.section_saefte));
            List<Product> saft_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_saefte));

            // Bier
            listDataHeader.add(getResources().getString(R.string.section_bier));
            List<Product> bier_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_bier));

            // Wein
            listDataHeader.add(getResources().getString(R.string.section_wein));
            List<Product> wein_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_wein));

            // Longdrinks
            listDataHeader.add(getResources().getString(R.string.section_longdrinks));
            List<Product> long_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_longdrinks));

            // Cocktails mit Alkohol
            listDataHeader.add(getResources().getString(R.string.section_cocktails));
            List<Product> cocktail_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_cocktails_alkohol));

            // Cocktails ohne Alkohol
            listDataHeader.add(getResources().getString(R.string.section_coktails_alkoholfrei));
            List<Product> cocktail_alkoholfrei_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_cocktails_alkoholfrei));

            // Shots
            listDataHeader.add(getResources().getString(R.string.section_shots));
            List<Product> shots_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_shots));

            // Sekt
            listDataHeader.add(getResources().getString(R.string.section_sekt));
            List<Product> sekt_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_sekt));

            // Warme Getränke
            listDataHeader.add(getResources().getString(R.string.section_warme_getraenke));
            List<Product> warme_getraenke_drink_list = db_handler.get_product_by_type(getResources().getString(R.string.typ_warme_getraenke));


            listDataChild.put(listDataHeader.get(0), soft_drink_list);
            listDataChild.put(listDataHeader.get(1), saft_drink_list);
            listDataChild.put(listDataHeader.get(2), bier_drink_list);
            listDataChild.put(listDataHeader.get(3), wein_drink_list);
            listDataChild.put(listDataHeader.get(4), long_drink_list);
            listDataChild.put(listDataHeader.get(5), cocktail_drink_list);
            listDataChild.put(listDataHeader.get(6), cocktail_alkoholfrei_drink_list);
            listDataChild.put(listDataHeader.get(7), shots_drink_list);
            listDataChild.put(listDataHeader.get(8), sekt_drink_list);
            listDataChild.put(listDataHeader.get(9), warme_getraenke_drink_list);


            ExpandableListView exp_lv = (ExpandableListView) findViewById(R.id.lvExp);
            exp_lv.setDivider(null);
            exp_lv.setDividerHeight(0);
            exp_lv.setAdapter(new CustomExpandableAdapterDrinks(this, listDataHeader, listDataChild));
            for (int i = 0; i < 10; i++) {
                exp_lv.expandGroup(i);
            }


        } catch (
                Exception e)

        {
            Log.e(LOG_TAG, "Error at setting adapter for typ_softgetraenke:\n" + e.toString());
        }


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Product>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
