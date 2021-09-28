package com.skypan.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.skypan.helloworld.R;

public class ContainerActivity extends AppCompatActivity {
    private AFragment aFragment;
    private BFragment bFragment;
    private Button mBtnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnChange = findViewById(R.id.btn_change);

        AFragment aFragment = new AFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment).commitAllowingStateLoss();

        mBtnChange.setOnClickListener((v) -> {
            if(null == bFragment){
                bFragment = new BFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).commitAllowingStateLoss();
        });
    }
}