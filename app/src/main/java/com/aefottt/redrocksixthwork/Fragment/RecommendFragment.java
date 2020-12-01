package com.aefottt.redrocksixthwork.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aefottt.redrocksixthwork.R;

public class RecommendFragment extends Fragment {

    private RecyclerView rvRecommend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        rvRecommend = view.findViewById(R.id.rv_recommend_fragment);
        return view;
    }
}