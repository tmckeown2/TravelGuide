package uk.ac.uclan.tmckeown2.travelguide.country;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.utils.NavigationViewHelper;

public class CountryInfoActivity extends AppCompatActivity {
    private static final String TAG = "CountryInfoActivity";

    private int ACTIVITY_NUM;
    private String mCountryName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        Log.d(TAG, "onCreate: Started.");

        ACTIVITY_NUM = getIntent().getIntExtra("EXTRA_ACTIVITY_NUM", 1);
        mCountryName = getIntent().getStringExtra("EXTRA_COUNTRY_NAME");

        setupToolbar();
        setupNavigationView();
    }

    // NavigationView Setup
    private void setupNavigationView() {
        Log.d(TAG, "setupNavigationView: Setting up NavigationView");
        BottomNavigationViewEx view = (BottomNavigationViewEx) findViewById(R.id.navBar);
        NavigationViewHelper.setupNavigationView(view);
        NavigationViewHelper.enableNavigation(getBaseContext(), view);

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    // Toolbar Setup
    private void setupToolbar() {
        //Toolbar toolbar = (Toolbar)findViewById(R.id.infoToolBar);
        //setSupportActionBar(toolbar);
    }
}
