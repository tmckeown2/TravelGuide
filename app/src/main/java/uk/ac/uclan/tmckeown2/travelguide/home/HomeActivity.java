package uk.ac.uclan.tmckeown2.travelguide.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import uk.ac.uclan.tmckeown2.travelguide.R;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";
    private static final int ACTIVITY_NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: Starting.");


    }
}
