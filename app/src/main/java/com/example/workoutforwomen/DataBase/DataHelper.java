package com.example.workoutforwomen.DataBase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataHelper extends SQLiteAssetHelper {

    static String DB_NAME = "fitness_db";
    static int DB_VERSION = 1;


    public DataHelper(Context context) {
        super(context, DB_NAME, null, null, DB_VERSION);
    }


}