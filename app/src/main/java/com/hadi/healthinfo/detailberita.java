package com.hadi.healthinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.hadi.healthinfo.home.redirectActivity;

public class detailberita extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailberita);
        getSupportActionBar().hide();

        if (getIntent().hasExtra("artikel_terpilih")) {
            Artikel detailartikel = getIntent().getParcelableExtra("artikel_terpilih");

            String imageRes = detailartikel.getGambar();
            String judul = detailartikel.getJudul();
            String kategori = detailartikel.getKategori();
            String tanggal = detailartikel.getTanggal();
            String isi = detailartikel.getIsi();

            ImageView gambar = findViewById(R.id.iv_gambar);
            Glide.with(this).load(imageRes).into(gambar);

            TextView tv_judul = findViewById(R.id.tv_judul);
            tv_judul.setText(judul);

            TextView tv_kategori = findViewById(R.id.tv_kategori);
            tv_kategori.setText(kategori);

            TextView tv_tanggal = findViewById(R.id.tv_tanggal);
            tv_tanggal.setText(tanggal);

            TextView tv_isi = findViewById(R.id.tv_isi);
            tv_isi.setText(isi);

            Button textsizeBig = findViewById(R.id.btn_textsizeBig);
            Button textsizeSmall = findViewById(R.id.btn_textsizesmall);
            Button share = findViewById(R.id.btn_share);

            textsizeBig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tv_isi.setTextSize(coverPixelToSP(12));
                }
            });

            textsizeSmall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tv_isi.setTextSize(coverPixelToSP(8));
                }
            });
        }

    }

    private int coverPixelToSP(int dps) {
        final float scale = this.getResources().getDisplayMetrics().density;
        return (int) (dps * scale);
    }

    public void ClickBack(View view) {
        redirectActivity(this, MainActivity.class);
    }


}