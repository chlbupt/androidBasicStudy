package com.skypan.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skypan.helloworld.R;

public class AActivity extends AppCompatActivity {
    private Button mBtnJump, mBtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);
        logLog("AActivity", "onCreate");
        mBtnJump = findViewById(R.id.jump);
        mBtnJump2 = findViewById(R.id.jump_2);
        mBtnJump2.setOnClickListener((v) -> {
            Intent intent = new Intent(AActivity.this, AActivity.class);
            startActivity(intent);
        });
        mBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 显示1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "天哥");
                bundle.putInt("number", 88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent, 0);

                // 显示2
                /*Intent intent = new Intent();
                intent.setClass(AActivity.this, BActivity.class);
                startActivity(intent);*/

                // 显示3
                /*Intent intent = new Intent();
                intent.setClassName(AActivity.this, "com.skypan.helloworld.jump.BActivity");
                startActivity(intent);*/

                // 显示4
               /* Intent intent = new Intent();
                intent.setComponent(new ComponentName(AActivity.this, "com.skypan.helloworld.jump.BActivity"));
                startActivity(intent);*/

                // 隐式
                /*Intent intent = new Intent();
                intent.setAction("com.skypan.test.BActivity");
                startActivity(intent);*/
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("title"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logLog("AActivity", "onNewIntent");
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