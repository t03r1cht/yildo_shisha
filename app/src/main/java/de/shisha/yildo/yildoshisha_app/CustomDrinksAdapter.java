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

public class CustomDrinksAdapter extends BaseAdapter {

    private static ArrayList<Product> getraenkeList;

    private LayoutInflater inflater;

    public CustomDrinksAdapter(Context context, ArrayList<Product> results) {
        this.getraenkeList = results;
        this.inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return this.getraenkeList.size();
    }

    public Object getItem(int pos) {
        return getraenkeList.get(pos);
    }

    public long getItemId(int pos) {
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.drinks_custom_row, null);
            holder = new ViewHolder();
            holder.drink_item_name = (TextView) convertView.findViewById(R.id.drink_item_name);
            holder.drink_item_preis = (TextView) convertView.findViewById(R.id.drink_item_preis);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.drink_item_name.setText(getraenkeList.get(position).getName());
        // Formatiere Float zu x.xx
        double preis = getraenkeList.get(position).getPreis();
        holder.drink_item_preis.setText(String.format("%.2f", preis) + " €");

        return convertView;
    }

    static class ViewHolder {
        TextView drink_item_name;
        TextView drink_item_preis;
    }

}
