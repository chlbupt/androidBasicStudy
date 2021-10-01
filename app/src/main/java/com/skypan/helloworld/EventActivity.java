package com.skypan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity{
    private Button mBtnClick, mBtnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        mBtnClick = findViewById(R.id.btn_click);
        mBtnMy = findViewById(R.id.btn_my);

        mBtnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---Listener---");
                        break;
                }
                return false;
            }
        });
        // 同一事件源绑定多个相同的事件监听器，以最后一个为准
        // 匿名内部类
        mBtnClick.setOnClickListener(v -> {
            Toast.makeText(this, "...click...", Toast.LENGTH_SHORT).show();
        });
        // 内部类
         mBtnClick.setOnClickListener(new OnClick());

        // 类自身
//        mBtnClick.setOnClickListener(this);

        // 通过外部类实现
//        MyClickListener myClickListener = new MyClickListener(this);
//        mBtnClick.setOnClickListener(myClickListener);
    }

    /*@Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_click:
                Toast.makeText(EventActivity.this, "...click", Toast.LENGTH_SHORT).show();
                break;
        }
    }*/

    /**
     * 通过内部类
     */
    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_click:
                    Toast.makeText(EventActivity.this, "click...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    // 通过标签绑定
    public void show(View v){
        switch (v.getId()) {
            case R.id.btn_click:
                Toast.makeText(EventActivity.this, "click...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("EventActivity", "---onTouchEvent---");
                break;
        }
        return false;
    }
}