package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ApartmentBillsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appartment_bills);

        FloatingActionButton fabAddContribution = findViewById(R.id.fab_add_contribution);
        fabAddContribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ApartmentBillsActivity.this, AddContributionActivity.class);
                startActivity(intent);
            }
        });
    }
}
