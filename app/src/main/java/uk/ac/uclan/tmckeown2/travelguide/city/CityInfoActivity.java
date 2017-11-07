package uk.ac.uclan.tmckeown2.travelguide.city;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.utils.NavigationViewHelper;

public class CityInfoActivity extends AppCompatActivity {
    private static final String TAG = "CityInfoActivity";

    private int ACTIVITY_NUM;
    private String mCityName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_info);
        Log.d(TAG, "onCreate: Started.");

        ACTIVITY_NUM = getIntent().getIntExtra("EXTRA_ACTIVITY_NUM", 2);
        mCityName = getIntent().getStringExtra("EXTRA_CITY_NAME");

        setupToolbar();
        setupNavigationView();
    }

    // BottomNavigationView setup
    private void setupNavigationView() {
        Log.d(TAG, "setupNavigationView: Setting up NavigationView");
        BottomNavigationViewEx view = (BottomNavigationViewEx) findViewById(R.id.navBar);
        NavigationViewHelper.setupNavigationView(view);
        NavigationViewHelper.enableNavigation(getBaseContext(), view);

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    // Toolbar setup
    private void setupToolbar() {
        //Toolbar toolbar = (Toolbar)findViewById(R.id.infoToolBar);
        //setSupportActionBar(toolbar);
    }
}
