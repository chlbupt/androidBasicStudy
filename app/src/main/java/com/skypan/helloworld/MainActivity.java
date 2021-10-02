package com.skypan.helloworld;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.skypan.helloworld.animate.AnimateActivity;
import com.skypan.helloworld.broadcast.BroadActivity;
import com.skypan.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnUI, mBtnEvent, mBtnData, mBtnBroadcast, mBtnAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroadcast = findViewById(R.id.btn_broadcast);
        mBtnAnimate = findViewById(R.id.btn_animate);

        setListeners();

        // 获取写入外部存储的权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    public void setListeners() {
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroadcast.setOnClickListener(onClick);
        mBtnAnimate.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_animate:
                    intent = new Intent(MainActivity.this, AnimateActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}