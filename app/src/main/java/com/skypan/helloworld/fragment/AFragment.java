package com.skypan.helloworld.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.skypan.helloworld.R;

public class AFragment extends Fragment {
    private TextView mTvTitle;
    private Button mBtnChange, mBtnReset, mBtnMessage;
    private BFragment bFragment;

    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment", "----onCreateView----");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);

        mBtnMessage.setOnClickListener((v) -> {
            ((ContainerActivity)getActivity()).setData("你好");
        });

        mBtnChange.setOnClickListener((v) -> {
            if (null == bFragment) {
                bFragment = new BFragment();
            }
//            getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
            Fragment fragment = getFragmentManager().findFragmentByTag("a");
            if (null != fragment) {
                getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
            } else {
                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });

        mBtnReset.setOnClickListener((v) -> {
            mTvTitle.setText("我是新文字");
        });

        if (getArguments() != null) {
            mTvTitle.setText(getArguments().getString("title"));
        }

    }

}