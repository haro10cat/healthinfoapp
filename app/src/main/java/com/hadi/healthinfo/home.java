package com.hadi.healthinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    DrawerLayout drawerLayout;
    private ArtikelAdapter adapter;
    private ArrayList<Artikel> dataList;
    private ArtikelAdapter.RecyclerViewClickListener listener;
    private SQLiteOpenHelper sqlHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);

        dataList = new ArrayList<>();
        sqlHelp = new SQLiteHelper(getBaseContext());


        RecyclerView recyclerView = findViewById(R.id.terkini);
        getData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(home.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        setOnClickListener();

        adapter = new ArtikelAdapter(dataList, listener);
        recyclerView.setAdapter(adapter);

        ImageView popimg = findViewById(R.id.img_populer);
        TextView popjudul = findViewById(R.id.pop_judul);
        TextView popkategori = findViewById(R.id.pop_kategori);
        TextView poptanggal = findViewById(R.id.pop_tanggal);

        Glide.with(this).load("https://res.cloudinary.com/dk0z4ums3/image/upload/v1626434845/attached_image/ketahui-perlengkapan-wajib-di-masa-pandemi-0-alodokter.jpg").into(popimg);
        popjudul.setText("Ketahui Perlengkapan Wajib di Masa Pandemi");
        popkategori.setText("Kesehatan");
        poptanggal.setText("16 Juli 2021");



        Button daftarberita = findViewById(R.id.btn_listberita);
        daftarberita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.fab1);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, chat.class);
                startActivity(intent);
                finish();
            }
        });

    }



    private void setOnClickListener() {
        listener = new ArtikelAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), detailberita.class);
                intent.putExtra("artikel_terpilih", dataList.get(position));
                startActivity(intent);
                finish();
            }
        };
    }

    @SuppressLint("Recycle")
    protected void getData() {
        SQLiteDatabase ReadData = sqlHelp.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + SQLiteHelper.MyColumns.NamaTabel, null);

        cursor.moveToFirst();

        for (int count = 0; count < cursor.getCount(); count++) {
            cursor.moveToPosition(count);

            dataList.add(new Artikel(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
        }
    }

//////////////////////////////////////////////////////////

//---------------------NAV DRAWER-----------------------//

//////////////////////////////////////////////////////////

    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void ClickLogo(View view) {
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view) {
        recreate();
    }

    public void ClickDashboard(View view) {
        redirectActivity(this, MainActivity.class);
    }

    public void ClickAboutUs(View view) {
        redirectActivity(this, about.class);
    }

    public void ClickLogout(View view) {
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Anda yakin akan keluar?");
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}