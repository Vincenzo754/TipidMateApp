package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This is the entry point of your app. It will decide whether to show the
        // LoginActivity or the HomeScreenActivity.

        // For now, we'll just go directly to the LoginActivity.
        // You can add logic here later to check if the user is already logged in.
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finish this activity so the user can't go back to it.
    }
}
