package de.shisha.yildo.yildoshisha_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marc on 16.11.2017.
 */

public class CustomNewsAdapter extends BaseAdapter {

    private static ArrayList<Product> getraenkeList;
    private static ArrayList<News> newsList;

    private LayoutInflater inflater;

    public CustomNewsAdapter(Context context, ArrayList<News> newsList) {
        this.newsList = newsList;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.newsList.size();
    }

    public Object getItem(int pos) {
        return newsList.get(pos);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.news_custom_row, null);
            holder = new ViewHolder();
            holder.news_item_name = (TextView) convertView.findViewById(R.id.news_title_tv);
            holder.news_item_text = (TextView) convertView.findViewById(R.id.news_text_tv);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.news_item_name.setText(newsList.get(position).getTitle());
        holder.news_item_text.setText(newsList.get(position).getText());

        return convertView;
    }

    static class ViewHolder {
        TextView news_item_name;
        TextView news_item_text;
    }

}
