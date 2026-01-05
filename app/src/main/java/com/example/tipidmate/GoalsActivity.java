package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GoalsActivity extends AppCompatActivity {

    private LinearLayout goalsContainer;
    private LinearLayout emptyState;
    private FloatingActionButton btnAddGoal;

    public static ArrayList<Goal> goals = new ArrayList<>();

    private ActivityResultLauncher<Intent> createGoalLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        goalsContainer = findViewById(R.id.goalsContainer);
        emptyState = findViewById(R.id.emptyState);
        btnAddGoal = findViewById(R.id.btnAddGoal);

        createGoalLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                        String title = result.getData().getStringExtra("goal_title");
                        String category = result.getData().getStringExtra("goal_category");
                        double amount = Double.parseDouble(
                                result.getData().getStringExtra("goal_amount")
                        );

                        Goal goal = new Goal(title, category, amount);
                        goals.add(goal);

                        refreshGoals();
                    }
                }
        );

        btnAddGoal.setOnClickListener(v -> {
            Intent intent = new Intent(this, GoalCreateActivity.class);
            createGoalLauncher.launch(intent);
        });

        refreshGoals();
    }

    private void refreshGoals() {
        goalsContainer.removeAllViews();

        if (goals.isEmpty()) {
            emptyState.setVisibility(View.VISIBLE);
            goalsContainer.addView(emptyState);
            return;
        }

        emptyState.setVisibility(View.GONE);

        for (int i = 0; i < goals.size(); i++) {
            Goal goal = goals.get(i);

            View item = LayoutInflater.from(this)
                    .inflate(android.R.layout.simple_list_item_2, goalsContainer, false);

            TextView text1 = item.findViewById(android.R.id.text1);
            TextView text2 = item.findViewById(android.R.id.text2);

            text1.setText(goal.title);
            text1.setTextColor(0xFFFFFFFF);

            text2.setText("₱" + goal.savedAmount + " / ₱" + goal.targetAmount);
            text2.setTextColor(0xFFAAAAAA);

            int index = i;
            item.setOnClickListener(v -> {
                Intent intent = new Intent(this, GoalDetailsActivity.class);
                intent.putExtra("goal_index", index);
                startActivity(intent);
            });

            goalsContainer.addView(item);
        }
    }
}
