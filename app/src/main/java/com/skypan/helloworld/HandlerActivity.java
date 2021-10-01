package com.skypan.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.skypan.helloworld.util.ToastUtil;

public class HandlerActivity extends AppCompatActivity {
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
       /* mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, ButtonActivity.class);
                startActivity(intent);
            }
        }, 3000);*/

        mHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        ToastUtil.showMsg(HandlerActivity.this, "线程通信成功");
                        break;
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                super.run();
                Message message = Message.obtain();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }.start();

    }
}