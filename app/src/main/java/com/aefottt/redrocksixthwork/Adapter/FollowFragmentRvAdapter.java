package com.aefottt.redrocksixthwork.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aefottt.redrocksixthwork.Bean.FollowItem;
import com.aefottt.redrocksixthwork.R;

import java.util.ArrayList;

public class FollowFragmentRvAdapter extends RecyclerView.Adapter<FollowFragmentRvAdapter.ViewHolder>{

    private final ArrayList<FollowItem> mList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvContent;
        public ViewHolder(View view){
            super(view);
            tvTitle = view.findViewById(R.id.tv_title_follow_fm_rv);
            tvContent = view.findViewById(R.id.tv_content_follow_fm_rv);
        }
    }

    public FollowFragmentRvAdapter(ArrayList<FollowItem> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follow_fm_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FollowItem item = mList.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvContent.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
