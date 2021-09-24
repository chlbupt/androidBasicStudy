package com.skypan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skypan.helloworld.util.ToastUtil;

import java.util.zip.Inflater;

public class ToastActivity extends AppCompatActivity {
    private Button mBtnToast1, mBtnToast2, mBtnToast3, mBtnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast_1);
        mBtnToast2 = findViewById(R.id.btn_toast_2);
        mBtnToast3 = findViewById(R.id.btn_toast_3);
        mBtnToast4 = findViewById(R.id.btn_toast_4);

        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
        mBtnToast4.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "居中Toast", Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;

                case R.id.btn_toast_3:
                    Toast toast = new Toast(getApplicationContext());
                    // 从布局文件创建视图
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View toastView = inflater.inflate(R.layout.layout_toast, null);
                    TextView textView = toastView.findViewById(R.id.tv_toast);
                    ImageView imageView = toastView.findViewById(R.id.iv_toast);

                    textView.setText("自定义Toast");
                    imageView.setImageResource(R.drawable.icon_smaile);
                    toast.setView(toastView);
                    toast.show();
                    break;

                case R.id.btn_toast_4:
                    ToastUtil.showMsg(getApplicationContext(), "Hello World");
                    break;
            }
        }
    }
}