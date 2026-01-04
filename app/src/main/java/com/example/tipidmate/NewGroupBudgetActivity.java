package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewGroupBudgetActivity extends AppCompatActivity {

    private RecyclerView membersRecyclerView;
    private MemberAdapter memberAdapter;
    private List<Member> memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group_budget);

        Toolbar toolbar = findViewById(R.id.top_app_bar);
        toolbar.setNavigationOnClickListener(v -> finish());

        membersRecyclerView = findViewById(R.id.members_recycler_view);
        membersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        memberList = new ArrayList<>();
        // Add a dummy member for now
        memberList.add(new Member("John Doe", "J"));

        memberAdapter = new MemberAdapter(memberList);
        membersRecyclerView.setAdapter(memberAdapter);

        TextView addMemberButton = findViewById(R.id.add_member_button);
        addMemberButton.setOnClickListener(v -> {
            // For now, let's just add another dummy member
            memberList.add(new Member("Jane Doe", "J"));
            memberAdapter.notifyItemInserted(memberList.size() - 1);
        });

        Button createBudgetButton = findViewById(R.id.create_budget_button);
        EditText budgetNameInput = findViewById(R.id.budget_name_input);
        EditText totalBudgetInput = findViewById(R.id.total_budget_input);

        createBudgetButton.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("budgetName", budgetNameInput.getText().toString());
            resultIntent.putExtra("totalBudget", totalBudgetInput.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
