package com.hadi.healthinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.hadi.healthinfo.home.redirectActivity;

public class chat extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    EditText edt_nama, edt_email, pertanyaan;
    Button btn_kirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);
        edt_nama = findViewById(R.id.edt_nama);
        edt_email = findViewById(R.id.edt_email);
        pertanyaan = findViewById(R.id.edt_pertanyaan);
        btn_kirim = findViewById(R.id.btn_kirim);

        btn_kirim.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (edt_nama.getText().length() == 0) {
            Toast.makeText(this, "Nama Masih Kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (edt_email.getText().length() == 0) {
            Toast.makeText(this, "Email Masih Kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pertanyaan.getText().length() == 0) {
            Toast.makeText(this, "Pertanyaan Masih Kosong!", Toast.LENGTH_SHORT).show();
            return;
        }
        new AlertDialog.Builder(this)
                .setTitle("Terima kasih")
                .setMessage("Terima kasih telah mengajukan pertanyaan Anda.\n" + "\nAnda dapat memeriksa balasan pada email Anda dalam waktu 1 x 24 jam.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(chat.this, home.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();

    }

    public void ClickBacktoHome(View view) {
        redirectActivity(this, home.class);
    }
}