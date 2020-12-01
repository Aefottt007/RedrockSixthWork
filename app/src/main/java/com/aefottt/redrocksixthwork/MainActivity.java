package com.aefottt.redrocksixthwork;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.aefottt.redrocksixthwork.Adapter.VpFragmentAdapter;
import com.aefottt.redrocksixthwork.Fragment.FollowFragment;
import com.aefottt.redrocksixthwork.Fragment.OtherFragment;
import com.aefottt.redrocksixthwork.Fragment.RecommendFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] labels = { "关注", "推荐", "热榜", "Android" };

    private TabLayout tlLayout;
    private ViewPager vp;
    private ArrayList<Fragment> fmList;
    private VpFragmentAdapter vpAdapter;
    private EditText etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.MIUISetStatusBarLightMode(this, true);
        setContentView(R.layout.activity_main);
        initView();
        tabSetting();
    }

    private void initView(){
        tlLayout = findViewById(R.id.tl_main_tab);
        vp = findViewById(R.id.vp_main_tab);
        ImageView ivAdd = findViewById(R.id.iv_main_add_fragment);
        etSearch = findViewById(R.id.et_main_search);

        fmList = new ArrayList<>();
        vpAdapter = new VpFragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fmList, labels);
        ivAdd.setOnClickListener(this);
    }

    private void tabSetting(){
        //Add Tab and set text
        for (String label : labels) {
            tlLayout.addTab(tlLayout.newTab().setText(label));
        }
        //add fragment to List
        fmList.add(new FollowFragment());
        fmList.add(new RecommendFragment());
        new OtherFragment();
        fmList.add(OtherFragment.newInstance(labels[2],labels[2]));
        fmList.add(OtherFragment.newInstance(labels[3],labels[3]));
        //设置ViewPager的适配器
        vp.setAdapter(vpAdapter);
        //设置TabLayout与ViewPager联动
        tlLayout.setupWithViewPager(vp, false);
        vp.setCurrentItem(1);
        tlLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if ("".equals(etSearch.getText().toString())){
                    Toast.makeText(getApplicationContext(), "请在输入框中输入Fragment的标题",Toast.LENGTH_SHORT).show();
                }else{
                    tab.setText(etSearch.getText().toString());
                    etSearch.setText("");
                    Toast.makeText(getApplicationContext(), "Modify Correctly!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.iv_main_add_fragment){
            if ("".equals(etSearch.getText().toString())){
                Toast.makeText(this, "请在输入框中输入Fragment的标题",Toast.LENGTH_SHORT).show();
            }else{
                String newTabTitle = etSearch.getText().toString();
                tlLayout.addTab(tlLayout.newTab().setText(newTabTitle));
                fmList.add(OtherFragment.newInstance(newTabTitle, newTabTitle));
                vpAdapter.notifyDataSetChanged();
                vp.setCurrentItem(tlLayout.getTabCount() - 1);
                etSearch.setText("");
                Toast.makeText(this, "Add Succeed!",Toast.LENGTH_SHORT).show();
            }
        }
    }
}