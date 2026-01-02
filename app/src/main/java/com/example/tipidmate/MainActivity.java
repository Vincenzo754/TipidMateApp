package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The home screen layout, which contains the BottomNavigationView
        setContentView(R.layout.home_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set the currently selected item in the nav bar
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        // Set up the listener for the navigation bar
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    // Already on the home screen, do nothing.
                    return true;
                } else if (itemId == R.id.navigation_group_budget) {
                    // Navigate to GroupBudgetActivity
                    startActivity(new Intent(getApplicationContext(), GroupBudgetActivity.class));
                    // Apply no animation for a seamless transition
                    overridePendingTransition(0, 0);
                    return true;
                }
                // TODO: Add cases for your other navigation items (Charts, Goals, etc.)
                return false;
            }
        });
    }
}
