package com.ict376.tym.ghattack;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MM_bottom extends Fragment {
    private Button mStart;
    MM_bottom.OnHeadlineSelectedListener mCallback;


    public MM_bottom(){}

    public static MM_bottom NewInstance(){
        MM_bottom fragment = new MM_bottom();
        return fragment;
    }
    public interface OnHeadlineSelectedListener{
        void startGame();
    }
    @Override
    public void onAttach(Context context){ //Sets up the interface
        super.onAttach(context);
        try {
            mCallback = (MM_bottom.OnHeadlineSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mm_bottom, container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        mStart = v.findViewById(R.id.playBut);
        mStart.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.startGame();
            }
        });
    }
}
