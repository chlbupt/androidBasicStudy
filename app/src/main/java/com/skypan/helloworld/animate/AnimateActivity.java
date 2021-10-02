package com.skypan.helloworld.animate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skypan.helloworld.R;

public class AnimateActivity extends AppCompatActivity {
    private Button mBtnFrame, mBtnTranslation, mBtnAttribute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate);

        mBtnAttribute = findViewById(R.id.btn_attribute);
        mBtnAttribute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimateActivity.this, ObjectAnimateActivity.class);
                startActivity(intent);
            }
        });
    }
}