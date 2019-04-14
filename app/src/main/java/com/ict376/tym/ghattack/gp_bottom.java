package com.ict376.tym.ghattack;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class gp_bottom extends Fragment {
    gp_bottom.OnHeadlineSelectedListener mCallback;
    TextView cardCount;

    public gp_bottom() {
        // Required empty public constructor
    }

    public static gp_bottom newInstance() {
        gp_bottom fragment = new gp_bottom();
        return fragment;
    }
    public interface OnHeadlineSelectedListener{
        void drawCard();
        void shuffleDeck();
    }
    @Override
    public void onAttach(Context context){ //Sets up the interface
        super.onAttach(context);
        try {
            mCallback = (gp_bottom.OnHeadlineSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gp_bottom, container, false);
    }
    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        Button mDrawBut = v.findViewById(R.id.drawBut);
        mDrawBut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.drawCard();
            }
        });
        Button mShuffleBut = v.findViewById(R.id.shuffleBut);
        mShuffleBut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCallback.shuffleDeck();
            }
        });
        cardCount =v.findViewById(R.id.cardsLeft);
    }
    public void updateCards(int stackCount){
        cardCount =getView().findViewById(R.id.cardsLeft);
        cardCount.setText(Integer.toString(stackCount));
    }
}
