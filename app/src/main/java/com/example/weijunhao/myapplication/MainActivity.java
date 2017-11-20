package com.example.weijunhao.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private Toolbar mToolbar;

    private Button mBtnLeft, mBtnRight;

    private ParentFragment mParentFragment;
    private ChildFragment mChildFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);

        mBtnLeft = findViewById(R.id.btn_left);
        mBtnRight = findViewById(R.id.btn_right);

        setSupportActionBar(mToolbar);
        setFragment(1);


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
    }

    public void setFragment(int num) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (num) {
            case 1:
                mChildFragment = new ChildFragment();
                transaction.replace(R.id.fl_content, mChildFragment, "111");
                transaction.commit();
                break;
            case 2:
                mParentFragment = new ParentFragment();
                transaction.replace(R.id.fl_content, mParentFragment, "222");
                transaction.commit();
                break;
        }
    }
}
