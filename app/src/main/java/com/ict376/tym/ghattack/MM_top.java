package com.ict376.tym.ghattack;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MM_top extends Fragment {
    MM_top.OnHeadlineSelectedListener mCallback;
    public MM_top(){}

    public static MM_top NewInstance(){
        MM_top fragment = new MM_top();
        return fragment;
    }
    public interface OnHeadlineSelectedListener{
        void reset();
    }
    @Override
    public void onAttach(Context context){ //Sets up the interface
        super.onAttach(context);
        try {
            mCallback = (MM_top.OnHeadlineSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mm_top, container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle savedInstanceState){
        int count= 0;
        Button mReset = v.findViewById(R.id.ResetButt);
        mReset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.reset();
            }
        });
        Button mSave = v.findViewById(R.id.SaveButt);
        Button mLoad = v.findViewById(R.id.LoadBut);

    }
    public void updateCardNum(int inNum){
        TextView cardNum = getView().findViewById(R.id.CardNumber);
        cardNum.setText(Integer.toString(inNum));
    }
}
