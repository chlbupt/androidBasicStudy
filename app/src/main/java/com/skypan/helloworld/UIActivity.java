package com.skypan.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.skypan.helloworld.gridview.GridViewActivity;
import com.skypan.helloworld.jump.AActivity;
import com.skypan.helloworld.listview.ListViewActivity;
import com.skypan.helloworld.recyclerview.RecyclerViewActivity;

public class UIActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mRadioButton;
    private Button mCheckBox;
    private Button mImageView;
    private Button mListView;
    private Button mGridview;
    private Button mRecyclerView;
    private Button mWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPop;
    private Button mBtnLifeCycle;
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mRadioButton = findViewById(R.id.btn_radiobutton);
        mCheckBox = findViewById(R.id.btn_checkbox);
        mImageView = findViewById(R.id.btn_imageview);
        mListView = findViewById(R.id.btn_mListview);
        mGridview = findViewById(R.id.btn_mGridview);
        mRecyclerView = findViewById(R.id.rv_main);
        mWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog =findViewById(R.id.btn_dialog);
        mBtnProgress =findViewById(R.id.btn_progress);
        mBtnCustomDialog = findViewById(R.id.btn_custom_dialog);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnLifeCycle = findViewById(R.id.btn_lifeCycle);
        mBtnJump = findViewById(R.id.btn_jump);

        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mRadioButton.setOnClickListener(onClick);
        mCheckBox.setOnClickListener(onClick);
        mImageView.setOnClickListener(onClick);
        mListView.setOnClickListener(onClick);
        mGridview.setOnClickListener(onClick);
        mRecyclerView.setOnClickListener(onClick);
        mWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPop.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        Intent intent = null;

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_textview:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_mListview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;

                case R.id.btn_mGridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;

                case R.id.rv_main:
                    intent = new Intent(UIActivity.this, RecyclerViewActivity.class);
                    break;

                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;

                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_pop:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_lifeCycle:
                    intent = new Intent(UIActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(UIActivity.this, AActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}