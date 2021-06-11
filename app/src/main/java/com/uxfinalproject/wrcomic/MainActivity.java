package com.uxfinalproject.wrcomic;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.uxfinalproject.wrcomic.databinding.ActivityMainBinding;
import com.uxfinalproject.wrcomic.ui.comics.ComicFragment;
import com.uxfinalproject.wrcomic.ui.home.HomeFragment;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
      //  setContentView(binding.getRoot());

      //  setSupportActionBar(binding.appBarMain.toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,
                                new HomeFragment()).commit();
                        navigationView.setCheckedItem(R.id.nav_home);
                        break;
                    case R.id.nav_comic:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,
                                new ComicFragment()).commit();
                        navigationView.setCheckedItem(R.id.nav_comic);
                        break;
                }
                System.out.println("clicked: "+menuItem.getItemId());
                System.out.println("comic: "+R.id.nav_comic);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
      /*  mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_comic, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_content_main,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

    }
/*
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_home);
                break;
            case R.id.nav_comic:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ComicFragment()).commit();
                navigationView.setCheckedItem(R.id.nav_comic);
                break;
        }
        System.out.println("clicked: "+menuItem.getItemId());
        System.out.println("comic: "+R.id.nav_comic);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
*/


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment_content_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}