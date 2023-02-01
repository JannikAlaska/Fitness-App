package com.example.fitness_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.annotation.Nullable;

public class Database_SQLite extends SQLiteOpenHelper {

    public Database_SQLite(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String DB_NAME = "fitness.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_FITNESS = "fitness";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_LEGEXTENSIONS = "legextensions";
    public static final String COLUMN_BUTTERFLY= "butterfly";
    public static final String COLUMN_CHESTPRESS = "chestpress";
    public static final String COLUMN_BACKEXTENSIONS = "backextensions";
    public static final String COLUMN_LATPULLDOWN = "latpulldown";
    public static final String COLUMN_LEGRAISES = "legraises";
    public static final String COLUMN_ABDOMINALCURL = "abdominalcurl";

    public static final String SQL_CREATE =
            "create table " + TABLE_FITNESS + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_DATE + "date not null, " +
                    COLUMN_LEGEXTENSIONS + "integer, " +
                    COLUMN_BUTTERFLY + "integer, " +
                    COLUMN_CHESTPRESS + "integer, " +
                    COLUMN_BACKEXTENSIONS + "integer, " +
                    COLUMN_LATPULLDOWN + "integer, " +
                    COLUMN_LEGRAISES + "boolean, " +
                    COLUMN_ABDOMINALCURL + "integer);";

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int i, int i1){

    }

    public long add_Session (int sLegextensions, int sButterfly, int sChestpress, int sBackextensions, int sLatpulldown, boolean sLegraises, int sAbdominalcurls){
        SQLiteDatabase db = this.getWritableDatabase();

        SimpleDateFormat fmtDate = new SimpleDateFormat("dd.MM.YYYY");
        String sDate_Now = fmtDate.format(new Date());

        ContentValues values = new ContentValues();
        values.put("Date", sDate_Now);
        values.put("Legextensions", sLegextensions);
        values.put("Butterfly", sButterfly);
        values.put("Chestpress", sChestpress);
        values.put("Backextensions", sBackextensions);
        values.put("Latpulldown", sLatpulldown);
        values.put("Legraises", sLegraises);
        values.put("Abdominalcurls", sAbdominalcurls);

        long newID = db.insert(TABLE_FITNESS, null, values);
        if (newID == -1)
        {
            return -1;
        }
        else
        {
            return newID;
        }
    }
}
