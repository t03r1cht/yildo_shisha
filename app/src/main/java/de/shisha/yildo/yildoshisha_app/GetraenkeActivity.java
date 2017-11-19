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
        final String typ_saefte = getResources().getString(R.string.typ_saefte);
        final String typ_bier = getResources().getString(R.string.typ_bier);
        final String typ_wein = getResources().getString(R.string.typ_wein);
        final String typ_longdrinks = getResources().getString(R.string.typ_longdrinks);
        final String typ_cocktails_alkohol = getResources().getString(R.string.typ_cocktails_alkohol);
        final String typ_cocktails_alkoholfrei = getResources().getString(R.string.typ_cocktails_alkoholfrei);
        final String typ_sekt = getResources().getString(R.string.typ_sekt);
        final String typ_shots = getResources().getString(R.string.typ_shots);
        final String typ_warme_getraenke = getResources().getString(R.string.typ_warme_getraenke);

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

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_apfelsaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_apfelsaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_orangensaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_orangensaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_ananassaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_ananassaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_kirschsaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_kirschsaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_bananensaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_bananensaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_maracujasaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_maracujasaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_cranberrysaft_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_cranberrysaft_2), 2.80, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_kiba_1), 3.20, typ_saefte));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sae_kiba_1), 2.80, typ_saefte));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_pils), 3.50, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_donauradler), 2.70, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_hefeweizen), 3.50, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_colaweizen), 3.50, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_saftweizen), 3.80, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_desperados), 3.50, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_corona), 3.50, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_heineken), 3.20, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_becks), 2.90, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_becks_green_lemon), 2.90, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_becks_ice), 2.90, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_pils_alkoholfrei), 3.00, typ_bier));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.bie_weizen_alkoholfrei), 3.00, typ_bier));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.wei_rotwein), 3.90, typ_wein));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.wei_weißwein), 3.90, typ_wein));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.wei_rose), 3.90, typ_wein));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.wei_weinschorle), 3.20, typ_wein));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_vodka_bull), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_vodka_lemon), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_jacky_cola), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_gin_tonic), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_jaeger_bull), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_jaeger_kirsch), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_malibu_kirsch), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_malibu_maracuja), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_cuba_libre), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_bacardi_cola), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_bacardi_orange), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_blanco_43), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_maracuja_43), 5.90, typ_longdrinks));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.lon_tropic_43), 5.90, typ_longdrinks));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_caipirinha), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_mojito), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_sex_on_the_beach), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_tequila_sunrise), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_malibu_sunrise), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_kingston), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_pina_colada), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_moonlight_shadow), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_bols_blue_ocean), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_swimming_pool), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_thats_life), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_yildo_gruene_suende), 6.90, typ_cocktails_alkohol));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cwa_long_island_ice_tea), 8.00, typ_cocktails_alkohol));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_virgin_mojito), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_virgin_colada), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_ipanema), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_dulcinea), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_coconut_kiss), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_summer_time), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_nix_drin), 5.90, typ_cocktails_alkoholfrei));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.cna_kiss_on_the_beach), 5.90, typ_cocktails_alkoholfrei));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_vodka), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_tequila_gold), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_tequila_silber), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_dos_mas), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_jaegermeister), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_jack_daniels), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_ficken), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_baileys), 2.40, typ_shots));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sho_sambuca), 2.40, typ_shots));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sek_sekt), 3.00, typ_sekt));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sek_sekt_orange), 3.40, typ_sekt));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sek_hugo), 3.20, typ_sekt));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.sek_aperol_spritz), 4.40, typ_sekt));

                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_kaffee_klein), 2.20, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_kaffee_groß), 2.90, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_espresso), 2.00, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_espresso_doppelt), 2.80, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_cappuccino), 2.90, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_latte_macchiato), 3.00, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_milchkaffee), 2.90, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_kakao), 2.90, typ_warme_getraenke));
                    db_handler.add_getraenk(new Getraenk(getResources().getString(R.string.war_tee), 2.50, typ_warme_getraenke));

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
