package com.javatpoint.user.foodie.Home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.javatpoint.user.foodie.R;
import com.javatpoint.user.foodie.fragment.HotDealFragment;
import com.javatpoint.user.foodie.fragment.MenuCatFragment;
import com.javatpoint.user.foodie.fragment.MenuFavFragment;
import com.javatpoint.user.foodie.fragment.YourOrdersFragment;

public class HomeFoodieActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment=null;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_foodie);

        ActionBar actionBar=getSupportActionBar();
        //actionBar.setTitle("Restaurant Home");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayout=findViewById(R.id.framelayout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_foodie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cart_status) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.l
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_home) {

        } else if (id == R.id.nav_menu_categories) {
            fragment=MenuCatFragment.newInstance();

        } else if (id == R.id.nav_your_orders) {
            fragment=YourOrdersFragment.newInstance();

        } else if (id == R.id.nav_your_favorites) {
            fragment=MenuFavFragment.newInstance();

        } else if (id == R.id.nav_hot_deals) {
            fragment=HotDealFragment.newInstance();

        }else if (id == R.id.nav_notification) {

        }else if (id == R.id.nav_settings) {

        }else if (id == R.id.nav_logout) {

        }


        loadFragment(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {

        if(fragment!=null)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout,fragment).commit();
        }
    }
}
