package com.hadi.healthinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class welcome extends AppCompatActivity implements View.OnClickListener {

    Button mulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();

        mulai = findViewById(R.id.btn_mulai);
        mulai.setOnClickListener(this);


    }

    public void onClick(View v) {
        Intent mulai = new Intent(welcome.this, home.class);
        startActivity(mulai);
        finish();
    }

}