package com.padc.yaepyaypar.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.padc.yaepyaypar.R;
import com.padc.yaepyaypar.fragments.FriendsListFragment;
import com.padc.yaepyaypar.fragments.ShareProfileListFragment;
import com.padc.yaepyaypar.fragments.YaypayparFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {

            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        navigationView.setNavigationItemSelectedListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState == null) {
            navigateToFriendList();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.left_menu_friend_list:
                navigateToFriendList();
                return true;
            case R.id.left_menu_share_your_profile:
                navigateToShareProfileList();
                return true;
            case R.id.left_menu_yaypaypar:
                navigateToYaypayparForm();

                return true;
        }

        return false;
    }

    private void navigateToFriendList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, FriendsListFragment.newInstance())
                .commit();
    }
    private void navigateToYaypayparForm() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, YaypayparFragment.newInstance())
                .commit();
    }

    private void navigateToShareProfileList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, ShareProfileListFragment.newInstance())
                .commit();
    }

}
