package uk.ac.uclan.tmckeown2.travelguide.city;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import uk.ac.uclan.tmckeown2.travelguide.R;
import uk.ac.uclan.tmckeown2.travelguide.utils.Card;
import uk.ac.uclan.tmckeown2.travelguide.utils.CardListAdapter;
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
        final ListView listView = (ListView) findViewById(R.id.cityListView);

        ArrayList<Card> cityList = new ArrayList<>();

        cityList.add(new Card("https://pbs.twimg.com/profile_images/839721704163155970/LI_TRk1z_400x40.jpg", "Test Test"));
        cityList.add(new Card("https://pbs.twimg.com/profile_images/839721704163155970/LI_TRk1z_400x40.jpg", "Goo Test"));

        CardListAdapter adapter = new CardListAdapter(getBaseContext(), R.layout.layout_card_view, cityList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Card card = (Card)listView.getItemAtPosition(i);

                Intent intent = new Intent(getBaseContext(), CityInfoActivity.class);
                intent.putExtra("EXTRA_NAME", card.getCardTitle());
                startActivity(intent);
            }
        });
    }
}
