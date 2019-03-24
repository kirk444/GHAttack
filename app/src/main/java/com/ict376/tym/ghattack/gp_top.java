package com.ict376.tym.ghattack;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class gp_top extends Fragment {
    gp_top.OnHeadlineSelectedListener mCallback;


    public gp_top() {
        // Required empty public constructor
    }
    public interface OnHeadlineSelectedListener{
        void addCurse();
        void subCurse();
        void addBless();
        void subBless();
    }

    @Override
    public void onAttach(Context context){ //Sets up the interface
        super.onAttach(context);
        try {
            mCallback = (gp_top.OnHeadlineSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    public static gp_top newInstance(){
        gp_top fragment = new gp_top();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gp_top, container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        Button mCurseUp = v.findViewById(R.id.curseUp);
        Button mCurseDown = v.findViewById(R.id.curseDown);
        Button mBlessUp = v.findViewById(R.id.blessUp);
        Button mBlessDown = v.findViewById(R.id.blessDown);
        final TextView mCurseCount = v.findViewById(R.id.curseCount);
        final TextView mBlessCount = v.findViewById(R.id.blessCount);
        mCurseUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.addCurse();
                int curses = Integer.parseInt(mCurseCount.getText().toString());
                curses += 1;
                mCurseCount.setText(Integer.toString(curses));
            }
        });
        mCurseDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                int curses = Integer.parseInt(mCurseCount.getText().toString());
                if(curses>0){
                    mCallback.subCurse();
                    curses -= 1;
                    mCurseCount.setText(Integer.toString(curses));
                }
            }
        });
        mBlessUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.addBless();
                int blesses = Integer.parseInt(mBlessCount.getText().toString());
                blesses += 1;
                mBlessCount.setText(Integer.toString(blesses));
            }
        });
        mBlessDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                int blesses = Integer.parseInt(mBlessCount.getText().toString());
                if(blesses > 0){
                    mCallback.subCurse();
                    blesses -= 1;
                    mBlessCount.setText(Integer.toString(blesses));
                }
            }
        });
    }
    public void UpdateBless(int adjust){

        TextView mBlessCount = getView().findViewById(R.id.blessCount);
        int curr = Integer.parseInt(mBlessCount.getText().toString());
        curr += adjust;
        mBlessCount.setText(Integer.toString(curr));
    }
    public void UpdateCurse(int adjust){
        TextView mCurseCount = getView().findViewById(R.id.curseCount);
        int curr = Integer.parseInt(mCurseCount.getText().toString());
        curr += adjust;
        mCurseCount.setText(Integer.toString(curr));
    }

}
