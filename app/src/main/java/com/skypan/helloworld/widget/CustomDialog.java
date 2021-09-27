package com.skypan.helloworld.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.skypan.helloworld.R;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView mTvTitle, mTvMessage, mTvCancel, mTvConfirm;
    private String title, message, cancel, confirm;
    private IOnCancelListener onCancelListener;
    private IOnConfirmListener onConfirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener onCancelListener) {
        this.cancel = cancel;
        this.onCancelListener = onCancelListener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener onConfirmListener) {
        this.confirm = confirm;
        this.onConfirmListener = onConfirmListener;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        // 解决自定义dialog宽度和高度的问题
        WindowManager windowManager = this.getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Point point = new Point();
        display.getSize(point);
        params.width = (int) (point.x * 0.8);
        getWindow().setAttributes(params);

        mTvTitle = findViewById(R.id.tv_title);
        mTvMessage = findViewById(R.id.tv_message);
        mTvCancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);

        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }

        if (!TextUtils.isEmpty(message)) {
            mTvMessage.setText(message);
        }

        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }

        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }

        // 绑定监听
        mTvCancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancel:
                if(onCancelListener != null){
                    onCancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.tv_confirm:
                if(onConfirmListener != null){
                    onConfirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog customDialog);
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog customDialog);
    }
}
