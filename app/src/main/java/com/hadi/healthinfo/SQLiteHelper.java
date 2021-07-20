package com.hadi.healthinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String nama_database = "db_health.db";
    private static final int versi_database = 1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, nama_database, null, versi_database);
    }

    static abstract class MyColumns implements BaseColumns, com.hadi.healthinfo.MyColumns {
        static final String NamaTabel = "Artikel";
        static final String id_artikel = "id";
        static final String Judul = "judul";
        static final String Kategori = "kategori";
        static final String Tanggal = "tanggal";
        static final String Isi = "isi";
        static final String Gambar = "gambar";

    }

    private static final String BUAT_TABEL = "CREATE TABLE " + MyColumns.NamaTabel +
            "(" + MyColumns.id_artikel + " TEXT PRIMARY KEY, "  + MyColumns.Judul + " TEXT NOT NULL, " + MyColumns.Kategori + " TEXT NOT NULL, " + MyColumns.Tanggal +
            " TEXT NOT NULL, " + MyColumns.Isi + " TEXT NOT NULL, " + MyColumns.Gambar + "TEXT NOT NULL)";

    private static final String HAPUS_TABEL = "DROP TABLE IF EXISTS " + MyColumns.NamaTabel;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(BUAT_TABEL);
        System.out.println("Database Sudah Dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(HAPUS_TABEL);
        onCreate(db);
    }


}