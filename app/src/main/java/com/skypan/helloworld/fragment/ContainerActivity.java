package com.skypan.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.skypan.helloworld.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle = findViewById(R.id.tv_title);

//        AFragment aFragment = new AFragment();
        aFragment = AFragment.newInstance("我是AFragment的newInstance");
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();


    }

    public void setData(String message){
        mTvTitle.setText(message);
    }
}