package uk.ac.uclan.tmckeown2.travelguide.city;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.utils.NavigationViewHelper;

public class CityActivity extends AppCompatActivity {
    private static final String TAG = "CityActivity";
    private static final int ACTIVITY_NUM = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Log.d(TAG, "onCreate: Starting.");

        setupNavigationView();
        setupCityInfo();
    }

    // Navigation Bar Setup
    private void setupNavigationView() {
        Log.d(TAG, "setupNavigationView: Setting up nav bar.");
        BottomNavigationViewEx view = findViewById(R.id.navBar);
        NavigationViewHelper.setupNavigationView(view);
        NavigationViewHelper.enableNavigation(getBaseContext(), view);

        Menu menu = view.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    // CityInfo Setup
    private void setupCityInfo() {

        /*
        Intent intent = new Intent(getBaseContext(), CityInfoActivity.class);
        intent.putExtra("EXTRA_ACTIVITY_NUM", ACTIVITY_NUM);
        intent.putExtra("EXTRA_COUNTRY_NAME", "NAME"); //TODO: Change "NAME" to country ID attached to card for SQL query in CountryInfo
         */
    }
}
