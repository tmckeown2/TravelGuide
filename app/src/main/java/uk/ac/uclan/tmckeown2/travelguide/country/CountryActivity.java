package uk.ac.uclan.tmckeown2.travelguide.country;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.city.CityInfoActivity;
import uk.ac.uclan.tmckeown2.travelguide.utils.Card;
import uk.ac.uclan.tmckeown2.travelguide.utils.CardListAdapter;
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
        final ListView listView = (ListView) findViewById(R.id.countryListView);

        ArrayList<Card> countryList = new ArrayList<>();

        countryList.add(new Card("https://pbs.twimg.com/profile_images/839721704163155970/LI_TRk1z_400x40.jpg", "Test Test"));
        countryList.add(new Card("https://pbs.twimg.com/profile_images/839721704163155970/LI_TRk1z_400x40.jpg", "Goo Test"));

        CardListAdapter adapter = new CardListAdapter(getBaseContext(), R.layout.layout_card_view, countryList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card)listView.getItemAtPosition(i);

                Intent intent = new Intent(getBaseContext(), CountryInfoActivity.class);
                intent.putExtra("EXTRA_NAME", card.getCardTitle());
                startActivity(intent);
            }
        });
    }
}
