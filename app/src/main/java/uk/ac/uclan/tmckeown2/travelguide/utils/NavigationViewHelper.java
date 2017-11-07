package uk.ac.uclan.tmckeown2.travelguide.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.home.HomeActivity;
import uk.ac.uclan.tmckeown2.travelguide.country.CountryActivity;
import uk.ac.uclan.tmckeown2.travelguide.city.CityActivity;
import uk.ac.uclan.tmckeown2.travelguide.favourites.FavouritesActivity;
import uk.ac.uclan.tmckeown2.travelguide.settings.SettingsActivity;

public class NavigationViewHelper {
    private static final String TAG = "NavigationViewHelper";

    public static void setupNavigationView(BottomNavigationViewEx view) {
        Log.d(TAG, "setupNavigationView: Setting up navigation view.");

        view.enableAnimation(false);
        view.enableItemShiftingMode(false);
        view.enableShiftingMode(false);
        view.setTextVisibility(true);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        Intent homeIntent = new Intent(context, HomeActivity.class);
                        context.startActivity(homeIntent);
                        break;
                    case R.id.ic_country:
                        Intent countryIntent = new Intent(context, CountryActivity.class);
                        context.startActivity(countryIntent);
                        break;
                    case R.id.ic_city:
                        Intent cityIntent = new Intent(context, CityActivity.class);
                        context.startActivity(cityIntent);
                        break;
                    case R.id.ic_favourites:
                        Intent favouritesIntent = new Intent(context, FavouritesActivity.class);
                        context.startActivity(favouritesIntent);
                        break;
                    case R.id.ic_settings:
                        Intent settingsIntent = new Intent(context, SettingsActivity.class);
                        context.startActivity(settingsIntent);
                        break;
                }

                return false;
            }
        });
    }
}
