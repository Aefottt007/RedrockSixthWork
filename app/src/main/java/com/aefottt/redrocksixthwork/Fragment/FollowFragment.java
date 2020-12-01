package com.aefottt.redrocksixthwork.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aefottt.redrocksixthwork.Adapter.FollowAdapterWrapper;
import com.aefottt.redrocksixthwork.Adapter.FollowFragmentRvAdapter;
import com.aefottt.redrocksixthwork.Bean.FollowItem;
import com.aefottt.redrocksixthwork.R;

import java.util.ArrayList;

public class FollowFragment extends Fragment {

    private final ArrayList<FollowItem> mList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        RecyclerView rvFollow = view.findViewById(R.id.rv_follow_fragment);
        addListItem();
        rvFollow.setLayoutManager(new LinearLayoutManager(getActivity()));
        FollowFragmentRvAdapter mainAdapter = new FollowFragmentRvAdapter(mList);
        FollowAdapterWrapper wrapperAdapter = new FollowAdapterWrapper(mainAdapter);
        View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.header_follow_fm_rv, rvFollow, false);
        View footerView = LayoutInflater.from(getActivity()).inflate(R.layout.footer_follow_fm_rv, rvFollow, false);
        wrapperAdapter.addHeaderView(headerView);
        wrapperAdapter.addFooterView(footerView);
        rvFollow.setAdapter(wrapperAdapter);
        return view;
    }

    private void addListItem(){
        for (int i = 0;i < 10;i++){
            mList.add(new FollowItem("Title"+i, "CONTENT"+i));
        }
    }
}