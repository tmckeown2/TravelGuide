package uk.ac.uclan.tmckeown2.travelguide.country;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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

        ACTIVITY_NUM = 1;
        mCountryName = getIntent().getStringExtra("EXTRA_NAME");

        setupNavigationView();
        setupInfoScreen();
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

    // Load data from database into the the view
    private void setupInfoScreen() {
        Log.d(TAG, "setupInfoScreen: Setting up Country Information for: " + mCountryName);

        // Change the info bar to display the name of the country and favourite state
        TextView text = (TextView) findViewById(R.id.infoName);
        text.setText(mCountryName);

        // Setup the OnClickListener for updating favourite info
        ImageButton fav = (ImageButton) findViewById(R.id.btnFavourite);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag() == R.drawable.ic_fav_outline) {
                    ((ImageButton)view).setImageResource(R.drawable.ic_fav_filled);
                    view.setTag(R.drawable.ic_fav_filled);

                    // Update the fav info in database
                }
                else {
                    ((ImageButton)view).setImageResource(R.drawable.ic_fav_outline);
                    view.setTag(R.drawable.ic_fav_outline);

                    // Update the fav info in database
                }
            }
        });

    }

}
