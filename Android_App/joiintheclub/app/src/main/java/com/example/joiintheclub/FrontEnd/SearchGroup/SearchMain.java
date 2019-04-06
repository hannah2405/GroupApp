package com.example.joiintheclub.FrontEnd.SearchGroup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.joiintheclub.FrontEnd.Group.GroupMain;
import com.example.joiintheclub.FrontEnd.Setting.SettingMain;
import com.example.joiintheclub.FrontEnd.UserProfile.UserProfileMain;
import com.example.joiintheclub.R;

@SuppressLint("Registered")
public class SearchMain extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);

        recyclerView = (RecyclerView) findViewById(R.id.search_recycle_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new SearchRecycleAdapter();
        recyclerView.setAdapter(adapter);




        Toolbar toolbar = (Toolbar) findViewById(R.id.Tbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.search_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.searchNav);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.search_drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    //@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            Intent intent = new Intent(SearchMain.this, UserProfileMain.class);
            startActivity(intent);
        } else if (id == R.id.search) {
            Intent intent = new Intent(SearchMain.this, SearchMain.class);
            startActivity(intent);

        } else if (id == R.id.club) {
            Intent intent = new Intent(SearchMain.this, GroupMain.class);
            startActivity(intent);

        } else if (id == R.id.setting) {
            Intent intent = new Intent(SearchMain.this, SettingMain.class);
            startActivity(intent);

        } else if (id == R.id.logout) {

        }

        DrawerLayout drawer = findViewById(R.id.search_drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

