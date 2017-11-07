package uk.ac.uclan.tmckeown2.travelguide.country;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.utils.NavigationViewHelper;

public class CountryActivity extends AppCompatActivity {
    private static final String TAG = "CountryActivity";
    private static final int ACTIVITY_NUM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        Log.d(TAG, "onCreate: Starting.");

        setupNavigationView();
        setupCountryInfo();
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

    // CountryInfo Setup
    private void setupCountryInfo() {

        /*
        Intent intent = new Intent(getBaseContext(), CountryInfoActivity.class);
        intent.putExtra("EXTRA_ACTIVITY_NUM", ACTIVITY_NUM);
        intent.putExtra("EXTRA_COUNTRY_NAME", "NAME"); //TODO: Change "NAME" to country ID attached to card for SQL query in CountryInfo
         */
    }
}
