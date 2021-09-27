package com.skypan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.skypan.helloworld.util.ToastUtil;

public class PopupWindowActivity extends AppCompatActivity {
    private Button mBtnPopup;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPopup = findViewById(R.id.btn_popup);
        mBtnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popView = getLayoutInflater().inflate(R.layout.layout_pop, null);
                mPop = new PopupWindow(popView, mBtnPopup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                // 设置绑定事件
                TextView textView = popView.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, "好");
                    }
                });

                mPop.setFocusable(true); // 点击btn，切换显示
                mPop.setOutsideTouchable(true); // 点击其他区域关闭
                mPop.showAsDropDown(mBtnPopup);
            }
        });
    }
}