package de.shisha.yildo.yildoshisha_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private ArrayList<News> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        newsList = new ArrayList<News>();

        newsList.add(new News("News Title", getResources().getString(R.string.aboutus_content)));
        newsList.add(new News("News Title2", getResources().getString(R.string.aboutus_content)));

        CustomNewsAdapter adapter = new CustomNewsAdapter(this, newsList);

        ListView news_lv = (ListView) findViewById(R.id.news_lv);
        news_lv.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
