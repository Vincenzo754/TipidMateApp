package com.example.tipidmate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupBudgetFragment extends Fragment {

    private RecyclerView groupBudgetsRecyclerView;
    private GroupBudgetAdapter groupBudgetAdapter;
    private List<GroupBudget> groupBudgetList;

    private ActivityResultLauncher<Intent> newGroupBudgetLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == AppCompatActivity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String budgetName = data.getStringExtra("budgetName");
                        String totalBudget = data.getStringExtra("totalBudget");
                        groupBudgetList.add(new GroupBudget(budgetName, "Created just now", "₱0 / ₱" + totalBudget, "On Track", 0));
                        groupBudgetAdapter.notifyItemInserted(groupBudgetList.size() - 1);
                    }
                }
            });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_budget, container, false);

        groupBudgetsRecyclerView = view.findViewById(R.id.group_budgets_recycler_view);
        groupBudgetsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        groupBudgetList = new ArrayList<>();
        // Add some sample data
        groupBudgetList.add(new GroupBudget("Apartment Bills", "Monthly utilities and rent", "₱ 6,500 / ₱ 10,000", "On Track", 65));
        groupBudgetList.add(new GroupBudget("Vacation Fund", "Trip to La Union", "₱ 4,500 / ₱ 4,000", "Overspent", 100));

        groupBudgetAdapter = new GroupBudgetAdapter(groupBudgetList);
        groupBudgetsRecyclerView.setAdapter(groupBudgetAdapter);

        FloatingActionButton fabAddGroupBudget = view.findViewById(R.id.fab_add_group_budget);
        fabAddGroupBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewGroupBudgetActivity.class);
                newGroupBudgetLauncher.launch(intent);
            }
        });

        return view;
    }
}
