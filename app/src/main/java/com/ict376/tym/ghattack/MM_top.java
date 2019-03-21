package com.ict376.tym.ghattack;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MM_top extends Fragment {
    public MM_top(){}

    public static MM_top NewInstance(){
        MM_top fragment = new MM_top();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mm_top, container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle savedInstanceState){

    }
}
