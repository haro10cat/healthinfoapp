package com.hadi.healthinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class about extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view) {
        home.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view) {
        home.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view) {
        home.redirectActivity(this, home.class);
    }

    public void ClickDashboard (View view) {
        home.redirectActivity(this, MainActivity.class);
    }

    public void ClickAboutUs (View view) {
        recreate();
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