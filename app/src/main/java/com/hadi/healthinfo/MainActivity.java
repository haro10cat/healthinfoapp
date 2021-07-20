package com.hadi.healthinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SQLiteHelper sqlHelp;
    private ArtikelAdapter adapter;
    private ArrayList<Artikel> dataList;
    private ArtikelAdapter.RecyclerViewClickListener listener;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);

        dataList = new ArrayList<>();
        sqlHelp = new SQLiteHelper(getBaseContext());
        saveData();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        setOnClickListener();
        adapter = new ArtikelAdapter(dataList, listener);

        recyclerView.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);


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

    private void saveData() {
        SQLiteDatabase create = sqlHelp.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.MyColumns.id_artikel, "a8");
        values.put(SQLiteHelper.MyColumns.Judul, "Ketahui Perlengkapan Wajib di Masa Pandemin");
        values.put(SQLiteHelper.MyColumns.Kategori, "Kesehatan");
        values.put(SQLiteHelper.MyColumns.Tanggal, "16 Juli 2021");
        values.put(SQLiteHelper.MyColumns.Isi, "Salah satu cara untuk menangkal penularan virus Corona di masa pandemi COVID-19 adalah membawa perlengkapan pelindung diri. Hal ini penting, karena jika Anda terjangkit virus Corona di tempat umum, bukannya tidak mungkin kesehatan keluarga Anda juga ikut terancam ketika Anda pulang ke rumah.\n" +
                "\n" +
                "Berbagai Perlengkapan Wajib selama Pandemi\n" +
                "Berikut adalah beberapa perlengkapan yang wajib dimiliki setiap orang selama masa pandemi COVID-19:\n" +
                "\n" +
                "1. Masker\n" +
                "Penggunaan masker terbukti efektif dalam menangkal penyebaran virus Corona. Oleh karena itu, Anda wajib memiliki dan menggunakannya dengan benar.\n" +
                "\n" +
                "Jika sebelumnya dianjurkan untuk menggunakan hanya satu masker, masyarakat kini diimbau untuk mengenakan masker ganda guna meningkatkan daya perlindungannya. Caranya, gunakan dulu masker bedah sebagai lapisan pertama di sebelah dalam, kemudian lapisi dengan masker kain di bagian luar.\n" +
                "\n" +
                "Pastikan Anda selalu membawa beberapa masker cadangan saat beraktivitas di luar rumah, terutama masker bedah yang harus diganti ketika sudah terlalu lembap.\n" +
                "\n" +
                "2. Sabun antiseptik\n" +
                "Antiseptik sering digunakan untuk mencegah terjadinya infeksi pada luka. Namun, di masa pandemi COVID-19, antiseptik juga dapat digunakan untuk membersihkan tangan.\n" +
                "\n" +
                "Mencuci tangan dengan sabun dan air mengalir efektif untuk membersihkan tangan dari kuman, termasuk virus. Dengan begitu, kuman dari tangan tidak masuk ke dalam tubuh melalui hidung, mata, atau mulut saat kita menyentuh wajah.\n" +
                "\n" +
                "Agar lebih optimal, Anda juga bisa menggunakan produk antiseptik sewaktu mencuci tangan, seperti sabun antiseptik atau antiseptik cair. Salah satunya adalah produk yang mengandung chloroxylenol. Zat ini ampuh untuk membunuh berbagai kuman dan virus.\n" +
                "\n" +
                "Tidak hanya untuk mencuci tangan, produk antiseptik cair tertentu bisa juga digunakan untuk mandi sebagai perlindungan ekstra. Cara menggunakannya cukup mudah, yaitu dengan melarutkan 1 tutup botol penuh antiseptik cair ke dalam bak mandi.\n" +
                "\n" +
                "3. Hand sanitizer\n" +
                "\n" +
                "Perlengkapan wajib di masa pandemi lainnya adalah hand sanitizer. Produk hand sanitizer bisa menjadi alternatif untuk mencuci tangan bila tidak ada air dan sabun. Pilihlah hand sanitizer yang memiliki kandungan alkohol setidaknya 60%.\n" +
                "\n" +
                "Meski demikian, perlu Anda ingat bahwa hand sanitizer tidak bisa menggantikan peran air dan sabun dalam membersihkan tangan dari kotoran dan kuman, termasuk virus Corona. Bila digunakan pada tangan yang sudah terlalu kotor, apalagi berminyak, penggunaan hand sanitizer tidak terlalu efektif dalam membasmi kuman.\n" +
                "\n" +
                "4. Disinfektan\n" +
                "Disinfektan berfungsi untuk membunuh mikroorganisme, seperti bakteri dan virus. Semprotan disinfektan yang umumnya terbuat dari campuran etanol dan klorin biasanya disemprotkan pada permukaan benda yang sering disentuh, seperti meja, pegangan kursi, keran wastafel, dan gagang pintu. Dan juga pada permukaan benda yang lunak, seperti sofa.\n" +
                "\n" +
                "Anda juga bisa menggunakan semprotan disinfektan yang bersifat aerosol. Selain membunuh virus dan kuman di permukaan benda, disinfektan ini juga bisa membasmi kuman di udara ketika semprotan jenis ini mengering. Pastikan menyemprotkan benda dengan disinfektan dari jarak 15–20 cm, lalu biarkan mengering sendiri dan tidak perlu dilap.\n" +
                "\n" +
                "Disinfektan aman disemprotkan ke pakaian atau baju, namun hindari menyemprotkan disinfektan ke tubuh secara langsung. Bila kulit terlalu sering terpapar disinfektan dalam konsentrasi yang terlalu pekat, bisa timbul iritasi kulit. Larutan disinfektan juga bisa berbahaya jika mengenai mata, terhirup, atau tertelan.\n" +
                "\n" +
                "Itulah perlengkapan wajib di masa pandemi COVID-19 beserta kegunaannya. Khusus untuk masker dan hand sanitizer, jangan lupa untuk selalu membawanya setiap Anda pergi ke luar rumah agar Anda dan keluarga terhindar dari bahaya virus Corona.\n" +
                "\n" +
                "Jangan lupa juga untuk tetap mematuhi protokol kesehatan lainnya, seperti melakukan physical distancing, menghindari keramaian, dan mendapatkan vaksinasi COVID-19.\n" +
                "\n" +
                "Jika Anda masih memiliki pertanyaan terkait jenis perlengkapan yang wajib dimiliki di masa pandemi atau pertanyaan apa pun seputar penyakit COVID-19, jangan ragu untuk berkonsultasi dengan dokter. Anda juga bisa chat langsung dengan dokter di aplikasi ALODOKTER.");

        values.put(SQLiteHelper.MyColumns.Gambar, "https://res.cloudinary.com/dk0z4ums3/image/upload/v1626434845/attached_image/ketahui-perlengkapan-wajib-di-masa-pandemi-0-alodokter.jpg");

        create.insert(SQLiteHelper.MyColumns.NamaTabel, null, values);
    }

    @SuppressLint("Recycle")
    protected void getData() {
        SQLiteDatabase ReadData = sqlHelp.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM " + SQLiteHelper.MyColumns.NamaTabel, null);

        cursor.moveToFirst();

        for (int count = 0; count < cursor.getCount(); count++) {
            cursor.moveToPosition(count);

            dataList.add(new Artikel (
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                    )
            );
        }
    }

//////////////////////////////////////////////////////////

//---------------------NAV DRAWER-----------------------//

//////////////////////////////////////////////////////////
    public void ClickMenu(View view) {
        home.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) { home.closeDrawer(drawerLayout); }

    public void ClickHome(View view) {
        home.redirectActivity(this, home.class);
    }

    public void ClickDashboard (View view) {
        recreate();
    }

    public void ClickAboutUs (View view) {
        home.redirectActivity(this, about.class);
    }

    public void ClickLogout (View view) {
        home.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        home.closeDrawer(drawerLayout);
    }
}