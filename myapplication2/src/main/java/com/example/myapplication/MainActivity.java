package com.example.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    private Button mBtnLeft, mBtnRight;
    private ChildFragment mChildFragment;


    private ArrayList<String> titleList = new ArrayList<String>() {{
        add("google drive");
        add("google+");
        add("google play");
    }};

    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>() {{
        add(new BlankFragment());
        add(new BlankFragment());
        add(new BlankFragment());
    }};

    private TabLayout tlMain;
    private ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);

        mBtnLeft = findViewById(R.id.btn_left);
        mBtnRight = findViewById(R.id.btn_right);

        mBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(1);
            }
        });

        mBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragment(2);

            }
        });

        tlMain = (TabLayout) findViewById(R.id.tlMain);
        vpMain = (ViewPager) findViewById(R.id.vpMain);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), titleList, fragmentList);
        vpMain.setAdapter(adapter);
        tlMain.setupWithViewPager(vpMain, true);
    }

    public class MyAdapter extends FragmentPagerAdapter {

        private ArrayList<String> titleList;
        private ArrayList<Fragment> fragmentList;

        public MyAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentList) {
            super(fm);
            this.titleList = titleList;
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }
    }

    public void setFragment(int num) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (num) {
            case 1:
                mChildFragment = new ChildFragment();
                transaction.replace(R.id.fl_content, mChildFragment, "111");
                transaction.commit();
                vpMain.setVisibility(View.GONE);
                break;
            case 2:
                if (mChildFragment.isVisible()) {
                    transaction.hide(mChildFragment);
                    transaction.commit();
                }
                vpMain.setVisibility(View.VISIBLE);


                break;
        }
    }

}
