package com.example.tipidmate;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroupBudgetAdapter extends RecyclerView.Adapter<GroupBudgetAdapter.GroupBudgetViewHolder> {

    private List<GroupBudget> groupBudgetList;

    public GroupBudgetAdapter(List<GroupBudget> groupBudgetList) {
        this.groupBudgetList = groupBudgetList;
    }

    @NonNull
    @Override
    public GroupBudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_group_budget, parent, false);
        return new GroupBudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupBudgetViewHolder holder, int position) {
        GroupBudget groupBudget = groupBudgetList.get(position);
        holder.budgetTitle.setText(groupBudget.getTitle());
        holder.budgetSubtitle.setText(groupBudget.getSubtitle());
        holder.budgetAmount.setText(groupBudget.getAmount());
        holder.budgetStatus.setText(groupBudget.getStatus());
        holder.budgetProgress.setProgress(groupBudget.getProgress());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ApartmentBillsActivity.class);
            // You can pass data to the activity here if needed
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return groupBudgetList.size();
    }

    static class GroupBudgetViewHolder extends RecyclerView.ViewHolder {

        TextView budgetTitle;
        TextView budgetSubtitle;
        TextView budgetAmount;
        TextView budgetStatus;
        ProgressBar budgetProgress;

        public GroupBudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            budgetTitle = itemView.findViewById(R.id.budget_title);
            budgetSubtitle = itemView.findViewById(R.id.budget_subtitle);
            budgetAmount = itemView.findViewById(R.id.budget_amount);
            budgetStatus = itemView.findViewById(R.id.budget_status);
            budgetProgress = itemView.findViewById(R.id.budget_progress);
        }
    }
}
