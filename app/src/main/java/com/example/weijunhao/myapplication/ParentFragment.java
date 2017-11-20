package com.example.weijunhao.myapplication;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParentFragment extends Fragment {

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

    public ParentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parent, container, false);
        tlMain = (TabLayout) view.findViewById(R.id.tlMain);
        vpMain = (ViewPager) view.findViewById(R.id.vpMain);

        MyAdapter adapter = new MyAdapter(getChildFragmentManager(), titleList, fragmentList);
        vpMain.setAdapter(adapter);
        tlMain.setupWithViewPager(vpMain, true);
        return view;
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
}
