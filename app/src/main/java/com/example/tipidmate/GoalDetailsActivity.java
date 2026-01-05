package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class GoalDetailsActivity extends AppCompatActivity {

    private Goal goal;
    private TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goal_details);

        int index = getIntent().getIntExtra("goal_index", -1);
        goal = GoalsActivity.goals.get(index);

        ImageView btnBack = findViewById(R.id.btnBack);
        Button btnAddSavings = findViewById(R.id.btnAddSavings);
        ImageView categoryIcon = findViewById(R.id.categoryIcon);

        tvProgress = findViewById(android.R.id.text2);

        btnBack.setOnClickListener(v -> finish());

        btnAddSavings.setOnClickListener(v -> {
            Intent intent = new Intent(this, GoalSavingsActivity.class);
            intent.putExtra("goal_index", index);
            startActivity(intent);
        });

        categoryIcon.setImageResource(getCategoryIcon(goal.category));
    }

    private int getCategoryIcon(String category) {
        switch (category) {
            case "Personal & Lifestyle": return R.drawable.ic_category_personal;
            case "Gifts & Celebrations": return R.drawable.ic_category_gifts;
            case "Emergency Fund": return R.drawable.ic_category_emergency;
            case "Education": return R.drawable.ic_category_education;
            case "Travel & Leisure": return R.drawable.ic_category_travel;
            case "Investments": return R.drawable.ic_category_investments;
            default: return R.drawable.ic_category_other;
        }
    }
}
