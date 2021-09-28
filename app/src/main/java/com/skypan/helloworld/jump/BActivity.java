package com.skypan.helloworld.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skypan.helloworld.R;

public class BActivity extends AppCompatActivity {
    private TextView mTvTitle;
    private Button mBtnFinish, mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        logLog("BActivity", "onCreate");

        mTvTitle = findViewById(R.id.tv_title);
        Bundle bundle = getIntent().getExtras();
        mTvTitle.setText(bundle.getString("name") + " : " + bundle.getInt("number"));

        mBtnFinish = findViewById(R.id.btn_finish);
        mBtnJump = findViewById(R.id.btn_2);

        mBtnJump.setOnClickListener((v) -> {
            Intent intent = new Intent(BActivity.this, AActivity.class);
            startActivity(intent);
        });

        mBtnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title", "我回来了");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logLog("BActivity", "onNewIntent");
    }

    private void logLog(String tag, String action) {
        Log.d(tag, "----" + action + "----");
        Log.d(tag, "taskid: " + getTaskId() + ", hash" + hashCode());
        logTaskName(tag);
    }

    private void logTaskName(String tag) {
        PackageManager packageManager = getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d(tag, activityInfo.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}