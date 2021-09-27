package com.skypan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skypan.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {
    private Button mBtnCustomDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        mBtnCustomDialog1 = findViewById(R.id.btn_custom_dialog_1);
        mBtnCustomDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
                customDialog.setTitle("提示")
                        .setMessage("确认删除此项？")
                        .setCancel("取消", new CustomDialog.IOnCancelListener() {
                            @Override
                            public void onCancel(CustomDialog customDialog) {
                                Toast.makeText(CustomDialogActivity.this, "cancel...", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog customDialog) {
                                Toast.makeText(CustomDialogActivity.this, "confirm...", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}