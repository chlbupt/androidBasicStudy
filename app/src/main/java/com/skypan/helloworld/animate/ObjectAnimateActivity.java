package com.skypan.helloworld.animate;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.skypan.helloworld.R;

public class ObjectAnimateActivity extends AppCompatActivity {
    private TextView mTvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animate);

        mTvTest = findViewById(R.id.tv_test);
        // 沿着y轴平移
//        mTvTest.animate().translationYBy(500).setDuration(2000).start();

        // 透明度渐变
//        mTvTest.animate().alpha(0).setDuration(2000).start();

       /* ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("ValueAnimator", String.valueOf(valueAnimator.getAnimatedValue()));
                Log.d("ValueAnimator", String.valueOf(valueAnimator.getAnimatedFraction()));
            }
        });

        valueAnimator.start();*/

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mTvTest, "translationY", 0, 500, 200);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}