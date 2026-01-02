package com.example.tipidmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        membersRecyclerView = findViewById(R.id.members_recycler_view);
        membersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        memberList = new ArrayList<>();
        // Add a dummy member for now
        memberList.add(new Member("John Doe", "J"));

        memberAdapter = new MemberAdapter(memberList);
        membersRecyclerView.setAdapter(memberAdapter);

        TextView addMemberButton = findViewById(R.id.add_member_button);
        addMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // For now, let's just add another dummy member
                memberList.add(new Member("Jane Doe", "J"));
                memberAdapter.notifyItemInserted(memberList.size() - 1);
            }
        });
    }
}
