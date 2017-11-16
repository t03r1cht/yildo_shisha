package de.shisha.yildo.yildoshisha_app;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SqliteHandler extends SQLiteOpenHelper {

    private static String LOG_TAG = "Yildo";

    // Jedes Mal, wenn die Datenbank z.B. mit neuen Spalten aktualisiert wird, muss die Version auch aktualisiert werden
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "yildo_db_getraenke.db";
    public static final String TABLE_GETRAENKE = "getraenke";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PREIS = "preis";

    public SqliteHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_GETRAENKE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_PREIS + " REAL"
                + ")";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GETRAENKE);
        onCreate(sqLiteDatabase);
    }

    // Neue Zeile zur Datenbank hinzufügen
    public void add_getraenk(Getraenk g) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, g.getName());
        values.put(COLUMN_PREIS, g.getPreis());

        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();

            db.insert(TABLE_GETRAENKE, null, values);
            db.close();
            Log.e(LOG_TAG, "added=" + g.getName() + " at " + getWritableDatabase().getPath());
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at SqliteHandler#add_getraenk:\n" + e.toString());
        }
    }

    // Zeile Löschen
    public void delete_getraenk(String name) {
        SQLiteDatabase db = null;
        try {
            db = getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_GETRAENKE + " WHERE " + COLUMN_NAME + "=\"" + name + "\";");
            db.close();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at SqliteHandler#delete_getraenk:\n" + e.toString());
        }
    }

    // Datenbank als String ausgeben
    public String database_to_string() {
        String db_string = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_GETRAENKE + " WHERE 1";

        // Cursor zeigt auf Stelle im Ergebnis
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("name")) != null) {
                db_string += c.getString(c.getColumnIndex("name")) + ":" + c.getDouble(c.getColumnIndex("preis"));
                db_string += "\n";
            }
        }
        db.close();
        return db_string;
    }

    public int get_db_items_count() {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_GETRAENKE + " WHERE 1";

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        int i = 0;

        while (!c.isAfterLast()) {
            i++;
        }
        db.close();
        return i;
    }


    public List<Getraenk> get_item_list() {
        List<Getraenk> gList = new ArrayList<Getraenk>();
        String selectQuery = "SELECT * FROM " + TABLE_GETRAENKE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Getraenk g = new Getraenk();
                g.set_id(Integer.parseInt(cursor.getString(0)));
                g.setName(cursor.getString(1));
                g.setPreis(cursor.getDouble(2));
                gList.add(g);
            } while (cursor.moveToNext());
        }
        return gList;
    }

    public ArrayList<Getraenk> get_item_list2() {
        ArrayList<Getraenk> gList = new ArrayList<Getraenk>();
        String selectQuery = "SELECT * FROM " + TABLE_GETRAENKE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Getraenk g = new Getraenk();
                g.set_id(Integer.parseInt(cursor.getString(0)));
                g.setName(cursor.getString(1));
                g.setPreis(cursor.getDouble(2));
                gList.add(g);
            } while (cursor.moveToNext());
        }
        return gList;
    }

    public List<String> get_item_name_list() {
        List<String> gList = new ArrayList<String>();
        String selectQuery = "SELECT * FROM " + TABLE_GETRAENKE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                gList.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return gList;
    }

    public void clear_table() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String query = "DELETE FROM " + TABLE_GETRAENKE + ";";
            db.execSQL(query);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error at SqliteHandler#clear_table:\n" + e.toString());
        }
        db.close();
    }

}
