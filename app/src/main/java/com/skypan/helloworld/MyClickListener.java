package com.skypan.helloworld;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

public class MyClickListener implements View.OnClickListener{
    private Activity activity;

    public MyClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(activity, "***Click***", Toast.LENGTH_SHORT).show();
    }
}
