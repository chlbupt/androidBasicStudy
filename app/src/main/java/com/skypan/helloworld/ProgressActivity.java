package com.skypan.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.skypan.helloworld.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {
    private ProgressBar mPb3;
    private Button mBtnStart, mProgressBarDialog1, mProgressBarDialog2, mProgressBarDialog3;
    private int MSG_PROGRESS = 0X123;
    private int MSG_DOWNLOAD = 0X124;
    private ProgressDialog dialog2, dialog3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mPb3 = findViewById(R.id.pb3);
//        mPb3.setProgress(50);
        mBtnStart = findViewById(R.id.btn_start);
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.sendEmptyMessage(MSG_PROGRESS);
            }
        });

        mProgressBarDialog1 = findViewById(R.id.btn_progress_dialog1);
        mProgressBarDialog2 = findViewById(R.id.btn_progress_dialog2);
        mProgressBarDialog3 = findViewById(R.id.btn_progress_dialog3);

        mProgressBarDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载...");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        ToastUtil.showMsg(ProgressActivity.this, "取消了");
                    }
                });
//                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });

        mProgressBarDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog2 = new ProgressDialog(ProgressActivity.this);
                dialog2.setTitle("提示");
                dialog2.setMessage("正在下载");
                dialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog2.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showMsg(ProgressActivity.this, "太棒了");
                    }
                });
                dialog2.show();
                new Download().start();
            }
        });

        mProgressBarDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog3 = new ProgressDialog(ProgressActivity.this);
                dialog3.setTitle("海贼王");
                dialog3.setMessage("正在下载...");
                dialog3.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog3.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ToastUtil.showMsg(ProgressActivity.this, "太棒了");
                    }
                });
                dialog3.show();
                handler.sendEmptyMessage(MSG_DOWNLOAD);
            }
        });
    }

    final Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == MSG_PROGRESS) {
                Log.d("DOWNLOAD", "MSG_PROGRESS");
                if (mPb3.getProgress() < 100) {
                    handler.postDelayed(() -> {
                        mPb3.setProgress(mPb3.getProgress() + 5);
                        handler.sendEmptyMessage(MSG_PROGRESS);
                    }, 500);
                } else {
                    Toast.makeText(ProgressActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                }
            } else if (msg.what == MSG_DOWNLOAD) {
                Log.d("DOWNLOAD", "MSG_DOWNLOAD");
                if (dialog3.getProgress() < 100) {
                    handler.postDelayed(() -> {
                        dialog3.setProgress(dialog3.getProgress() + 10);
                        handler.sendEmptyMessage(MSG_DOWNLOAD);
                    }, 500);
                } else {
                    dialog3.dismiss();
                    Toast.makeText(ProgressActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                }
            }

        }
    };

    class Download extends Thread {
        @Override
        public void run() {
            int max = dialog2.getMax();
            for (int i = 0; i < max; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog2.setProgress(dialog2.getProgress() + 5);
            }
        }
    }
}