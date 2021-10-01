package com.skypan.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skypan.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShared, mBtnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnShared = findViewById(R.id.btn_shared);
        mBtnFile= findViewById(R.id.btn_file);

        mBtnShared.setOnClickListener(this);
        mBtnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_shared:
                intent = new Intent(this, SharedActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(this, FileActivity.class);
                break;
        }

        startActivity(intent);
    }
}