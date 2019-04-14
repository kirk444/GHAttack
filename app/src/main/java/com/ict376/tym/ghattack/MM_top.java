package com.ict376.tym.ghattack;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
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
        void save();
        void load();
        void classChange(String outClass);
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
        mSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.save();
            }
        });
        Button mLoad = v.findViewById(R.id.LoadBut);
        mLoad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.load();
            }
        });
        final Spinner mClassSelect = v.findViewById(R.id.ClassSelect);
        mClassSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mCallback.classChange(mClassSelect.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
