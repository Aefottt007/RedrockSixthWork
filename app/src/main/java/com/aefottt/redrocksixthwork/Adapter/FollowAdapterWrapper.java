package com.aefottt.redrocksixthwork.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FollowAdapterWrapper extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    enum ITEM_TYPE{
        HEADER,
        FOOTER,
        MAIN
    }

    private final FollowFragmentRvAdapter mainAdapter;
    private View headerView;
    private View footerView;

    public FollowAdapterWrapper(FollowFragmentRvAdapter mainAdapter){
        this.mainAdapter = mainAdapter;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return ITEM_TYPE.HEADER.ordinal();
        }else if (position == mainAdapter.getItemCount() + 1){
            return ITEM_TYPE.FOOTER.ordinal();
        }else{
            return ITEM_TYPE.MAIN.ordinal();
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.HEADER.ordinal()){
            return new RecyclerView.ViewHolder(headerView) {};
        }else if (viewType == ITEM_TYPE.FOOTER.ordinal()){
            return new RecyclerView.ViewHolder(footerView) {};
        }else{
            return mainAdapter.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0){
            return;
        }else if(position == mainAdapter.getItemCount() + 1){
            return;
        }else{
            mainAdapter.onBindViewHolder((FollowFragmentRvAdapter.ViewHolder)holder, position - 1);
        }
    }

    @Override
    public int getItemCount() {
        return mainAdapter.getItemCount() + 2;
    }

    public void addHeaderView(View header){
        headerView = header;
    }

    public void addFooterView(View footer){
        footerView = footer;
    }
}
