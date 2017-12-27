package de.shisha.yildo.yildoshisha_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.Menu;
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

    SqliteHandler db_handler;

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
//        nav_header_tv = (TextView) nav_view.getHeaderView(0).findViewById(R.id.nav_header_tv);

        // Register NavigationView.OnNavigationItemSelectedListener
        setNavigationViewListener();
        // Set custom font
        try {
            tf_raleway = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Regular.ttf");
            nav_header_tv.setTypeface(tf_raleway);

            tf_greatvibes = Typeface.createFromAsset(getAssets(), "fonts/GreatVibes-Regular.ttf");
//            ((TextView) findViewById(R.id.main_logo_tv)).setTypeface(tf_greatvibes);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Caught error when trying to set new font:");
            Log.e(LOG_TAG, e.toString());
        }

        new SetupDB().execute(this);
        Log.d(LOG_TAG, "DB filled...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (id == R.id.nav_home) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_home");
            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            this.startActivity(intent);
            Log.d(LOG_TAG, "Switched to intent 'HomeActivity'");
        } else if (id == R.id.nav_aboutUs) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_aboutUs");

            try {
                Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'AboutUsActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if (id == R.id.nav_drinks) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_drinks");

            try {
                Intent intent = new Intent(HomeActivity.this, DrinksActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'DrinksActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if (id == R.id.nav_news) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_news");

            try {
                Intent intent = new Intent(HomeActivity.this, NewsActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'NewsActivity'");
                Log.e(LOG_TAG, e.toString());
            }
//        } else if (id == R.id.nav_database) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//            Log.d(LOG_TAG, "Clicked nav_database");
//
//            try {
//                Intent intent = new Intent(HomeActivity.this, GetraenkeActivity.class);
//                this.startActivity(intent);
//            } catch (Exception e) {
//                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'GetraenkeActivity'");
//                Log.e(LOG_TAG, e.toString());
//            }
        } else if (id == R.id.nav_smokes) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_smokes");

            try {
                Intent intent = new Intent(HomeActivity.this, ShishaActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'ShishaActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if (id == R.id.nav_imprint) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_imprint");

            try {
                Intent intent = new Intent(HomeActivity.this, ImpressumActivity.class);
                this.startActivity(intent);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Caught exception when trying to switch intent to 'ImpressumActivity'");
                Log.e(LOG_TAG, e.toString());
            }
        } else if (id == R.id.nav_exit) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Log.d(LOG_TAG, "Clicked nav_exit");
            finish();
            moveTaskToBack(true);
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
        for (int i = 0; i < size; i++) {
            nav_view.getMenu().getItem(i).setChecked(false);
        }
    }


    private class SetupDB extends AsyncTask<Context, Void, Integer> {

        @Override
        protected Integer doInBackground(Context... context) {
            // Database
            try {
                db_handler = new SqliteHandler(context[0], null, null, 1);
            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception caught at opening new GetraenkeActivity#db_handler");
                Log.e(LOG_TAG, e.toString());
            }

            Log.d(LOG_TAG, "DB Handler done");

            if (db_handler == null) {
                Log.d(LOG_TAG, "db handler null");
            } else {
                Log.d(LOG_TAG, "db handler not null");
            }

            Log.d(LOG_TAG, "Init db...");
            db_handler.clear_table();
            Log.d(LOG_TAG, "DB cleared");

            try {
                final String typ_softgetraenke = getResources().getString(R.string.typ_softgetraenke);
                final String typ_saefte = getResources().getString(R.string.typ_saefte);
                final String typ_bier = getResources().getString(R.string.typ_bier);
                final String typ_wein = getResources().getString(R.string.typ_wein);
                final String typ_longdrinks = getResources().getString(R.string.typ_longdrinks);
                final String typ_cocktails_alkohol = getResources().getString(R.string.typ_cocktails_alkohol);
                final String typ_cocktails_alkoholfrei = getResources().getString(R.string.typ_cocktails_alkoholfrei);
                final String typ_sekt = getResources().getString(R.string.typ_sekt);
                final String typ_shots = getResources().getString(R.string.typ_shots);
                final String typ_warme_getraenke = getResources().getString(R.string.typ_warme_getraenke);

                final String typ_7days = getResources().getString(R.string.typ_7days);
                final String typ_adalya = getResources().getString(R.string.typ_adalya);
                final String typ_al_waha = getResources().getString(R.string.typ_al_waha);
                final String typ_al_fakher = getResources().getString(R.string.typ_al_fakher);
                final String typ_chillma = getResources().getString(R.string.typ_chillma);
                final String typ_chaos = getResources().getString(R.string.typ_chaos);
                final String typ_yildo = getResources().getString(R.string.typ_yildo);
                final String typ_maridan_tobacco = getResources().getString(R.string.typ_maridan_tobacco);
                final String typ_hasso = getResources().getString(R.string.typ_hasso);
                final String typ_social_smoke = getResources().getString(R.string.typ_social_smoke);
                final String typ_oscar = getResources().getString(R.string.typ_oscar);

                db_handler.add_product(new Product(getResources().getString(R.string.sof_coca_cola), 2.30, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_fanta), 2.30, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_spezi), 2.30, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_sprite), 2.30, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_mineralwasser_klein), 2.30, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_mineralwasser_groß), 3.20, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_red_bull), 3.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_red_bull_zero), 3.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_tonic_water), 2.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_bitter_lemon), 2.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_ginger_ale), 2.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_schweppes_russian_wild_berry), 2.80, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_eistee_pfirsich), 3.50, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_eistee_granatapfel), 3.50, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_eistee_zitrone), 3.50, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_orangina_rot), 2.60, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_orangina_gelb), 2.60, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_moloko), 3.50, typ_softgetraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.sof_28black), 4.00, typ_softgetraenke));

                db_handler.add_product(new Product(getResources().getString(R.string.sae_apfelsaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_apfelsaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_orangensaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_orangensaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_ananassaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_ananassaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_kirschsaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_kirschsaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_bananensaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_bananensaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_maracujasaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_maracujasaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_cranberrysaft_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_cranberrysaft_2), 2.80, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_kiba_1), 3.20, typ_saefte));
                db_handler.add_product(new Product(getResources().getString(R.string.sae_kiba_2), 2.80, typ_saefte));

                db_handler.add_product(new Product(getResources().getString(R.string.bie_pils), 3.50, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_donauradler), 2.70, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_hefeweizen), 3.50, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_colaweizen), 3.50, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_saftweizen), 3.80, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_desperados), 3.50, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_corona), 3.50, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_heineken), 3.20, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_becks), 2.90, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_becks_green_lemon), 2.90, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_becks_ice), 2.90, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_pils_alkoholfrei), 3.00, typ_bier));
                db_handler.add_product(new Product(getResources().getString(R.string.bie_weizen_alkoholfrei), 3.00, typ_bier));

                db_handler.add_product(new Product(getResources().getString(R.string.wei_rotwein), 3.90, typ_wein));
                db_handler.add_product(new Product(getResources().getString(R.string.wei_weißwein), 3.90, typ_wein));
                db_handler.add_product(new Product(getResources().getString(R.string.wei_rose), 3.90, typ_wein));
                db_handler.add_product(new Product(getResources().getString(R.string.wei_weinschorle), 3.20, typ_wein));

                db_handler.add_product(new Product(getResources().getString(R.string.lon_vodka_bull), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_vodka_lemon), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_jacky_cola), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_gin_tonic), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_jaeger_bull), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_jaeger_kirsch), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_malibu_kirsch), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_malibu_maracuja), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_cuba_libre), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_bacardi_cola), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_bacardi_orange), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_blanco_43), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_maracuja_43), 5.90, typ_longdrinks));
                db_handler.add_product(new Product(getResources().getString(R.string.lon_tropic_43), 5.90, typ_longdrinks));

                db_handler.add_product(new Product(getResources().getString(R.string.cwa_caipirinha), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_mojito), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_sex_on_the_beach), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_tequila_sunrise), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_malibu_sunrise), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_kingston), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_pina_colada), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_moonlight_shadow), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_bols_blue_ocean), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_swimming_pool), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_thats_life), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_yildo_gruene_suende), 6.90, typ_cocktails_alkohol));
                db_handler.add_product(new Product(getResources().getString(R.string.cwa_long_island_ice_tea), 8.00, typ_cocktails_alkohol));

                db_handler.add_product(new Product(getResources().getString(R.string.cna_virgin_mojito), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_virgin_colada), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_ipanema), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_dulcinea), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_coconut_kiss), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_summer_time), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_nix_drin), 5.90, typ_cocktails_alkoholfrei));
                db_handler.add_product(new Product(getResources().getString(R.string.cna_kiss_on_the_beach), 5.90, typ_cocktails_alkoholfrei));

                db_handler.add_product(new Product(getResources().getString(R.string.sho_vodka), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_tequila_gold), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_tequila_silber), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_dos_mas), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_jaegermeister), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_jack_daniels), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_ficken), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_baileys), 2.40, typ_shots));
                db_handler.add_product(new Product(getResources().getString(R.string.sho_sambuca), 2.40, typ_shots));

                db_handler.add_product(new Product(getResources().getString(R.string.sek_sekt), 3.00, typ_sekt));
                db_handler.add_product(new Product(getResources().getString(R.string.sek_sekt_orange), 3.40, typ_sekt));
                db_handler.add_product(new Product(getResources().getString(R.string.sek_hugo), 3.20, typ_sekt));
                db_handler.add_product(new Product(getResources().getString(R.string.sek_aperol_spritz), 4.40, typ_sekt));

                db_handler.add_product(new Product(getResources().getString(R.string.war_kaffee_klein), 2.20, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_kaffee_groß), 2.90, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_espresso), 2.00, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_espresso_doppelt), 2.80, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_cappuccino), 2.90, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_latte_macchiato), 3.00, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_milchkaffee), 2.90, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_kakao), 2.90, typ_warme_getraenke));
                db_handler.add_product(new Product(getResources().getString(R.string.war_tee), 2.50, typ_warme_getraenke));

                db_handler.add_product(new Product(getResources().getString(R.string.sda_cold_peach), 8.00, typ_7days));
                db_handler.add_product(new Product(getResources().getString(R.string.sda_cold_melon), 8.00, typ_7days));

                db_handler.add_product(new Product(getResources().getString(R.string.ada_love_66), 8.00, typ_adalya));
                db_handler.add_product(new Product(getResources().getString(R.string.ada_lady_killer), 8.00, typ_adalya));
                db_handler.add_product(new Product(getResources().getString(R.string.ada_hawai), 8.00, typ_adalya));

                db_handler.add_product(new Product(getResources().getString(R.string.alw_kaugummi_zimt), 8.00, typ_al_waha));
                db_handler.add_product(new Product(getResources().getString(R.string.alw_hot_and_cold), 8.00, typ_al_waha));

                db_handler.add_product(new Product(getResources().getString(R.string.alf_doppel_apfel), 9.00, typ_al_fakher));
                db_handler.add_product(new Product(getResources().getString(R.string.alf_traube_minze), 9.00, typ_al_fakher));

                db_handler.add_product(new Product(getResources().getString(R.string.chi_persian_apple), 9.00, typ_chillma));

                db_handler.add_product(new Product(getResources().getString(R.string.cha_babylou), 8.00, typ_chaos));
                db_handler.add_product(new Product(getResources().getString(R.string.cha_oriental_cay), 8.00, typ_chaos));
                db_handler.add_product(new Product(getResources().getString(R.string.cha_riddle), 8.00, typ_chaos));
                db_handler.add_product(new Product(getResources().getString(R.string.cha_wtf), 8.00, typ_chaos));
                db_handler.add_product(new Product(getResources().getString(R.string.cha_crazy_gobline), 8.00, typ_chaos));

                db_handler.add_product(new Product(getResources().getString(R.string.yil_eisbonbon), 9.00, typ_yildo));

                db_handler.add_product(new Product(getResources().getString(R.string.mar_tingle_tangle), 9.00, typ_maridan_tobacco));

                db_handler.add_product(new Product(getResources().getString(R.string.has_cherry_chito), 8.00, typ_hasso));
                db_handler.add_product(new Product(getResources().getString(R.string.has_grape_addiction), 8.00, typ_hasso));
                db_handler.add_product(new Product(getResources().getString(R.string.has_lemon_porn), 8.00, typ_hasso));

                db_handler.add_product(new Product(getResources().getString(R.string.soc_lemon_chill), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_lemon_drop), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_pink_lemonade), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_watermelon_chill), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_wildberry_chill), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_blue_raspberry), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_baja_blue), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_twisted), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_pear_chill), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_pistach_breeze), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_voltage), 11.00, typ_social_smoke));
                db_handler.add_product(new Product(getResources().getString(R.string.soc_white_gummy_bear), 11.00, typ_social_smoke));

                db_handler.add_product(new Product(getResources().getString(R.string.osc_african_queen), 9.00, typ_oscar));
                db_handler.add_product(new Product(getResources().getString(R.string.osc_lime_light), 9.00, typ_oscar));
                db_handler.add_product(new Product(getResources().getString(R.string.osc_dracula), 9.00, typ_oscar));
                db_handler.add_product(new Product(getResources().getString(R.string.osc_fame), 9.00, typ_oscar));
                db_handler.add_product(new Product(getResources().getString(R.string.osc_cleopatra), 9.00, typ_oscar));

            } catch (Exception e) {
                Log.e(LOG_TAG, "Exception caught at HomeActivity#onCreate");
                Log.e(LOG_TAG, e.toString());
            }
            return 1;
        }
    }
}

