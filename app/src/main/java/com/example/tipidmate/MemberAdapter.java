package com.example.tipidmate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {

    private List<Member> memberList;

    public MemberAdapter(List<Member> memberList) {
        this.memberList = memberList;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_member, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        Member member = memberList.get(position);
        holder.memberName.setText(member.getName());
        holder.avatarText.setText(member.getAvatarText());
    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView memberName;
        TextView avatarText;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            memberName = itemView.findViewById(R.id.member_name);
            avatarText = itemView.findViewById(R.id.avatar_text);
        }
    }
}
