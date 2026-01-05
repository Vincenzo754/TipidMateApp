package com.example.tipidmate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GoalSavingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_savings);

        ImageView btnBack = findViewById(R.id.btnBack);
        EditText etAmount = findViewById(R.id.etAmount);
        Button btnSave = findViewById(R.id.btnSave);

        int index = getIntent().getIntExtra("goal_index", -1);
        Goal goal = GoalsActivity.goals.get(index);

        btnBack.setOnClickListener(v -> finish());

        btnSave.setOnClickListener(v -> {
            if (etAmount.getText().toString().isEmpty()) return;

            double add = Double.parseDouble(etAmount.getText().toString());
            goal.savedAmount += add;

            finish();
        });
    }
}
