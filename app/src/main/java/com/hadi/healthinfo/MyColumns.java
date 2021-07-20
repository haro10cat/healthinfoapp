package com.hadi.healthinfo;

import android.database.sqlite.SQLiteDatabase;

public interface MyColumns {
    void onCreate(SQLiteDatabase db);

    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}