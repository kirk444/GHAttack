package com.ict376.tym.ghattack;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class gp_top extends Fragment {
    gp_top.OnHeadlineSelectedListener mCallback;
    Toast toast;


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
        final ImageView mInvisIcon = v.findViewById(R.id.invisIcon);
        mInvisIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mInvisIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.invis).getConstantState()){
                    mInvisIcon.setImageResource(R.drawable.noinvis);
                }else{
                    mInvisIcon.setImageResource(R.drawable.invis);
                }
            }
        });
        final ImageView mstrIcon = v.findViewById(R.id.strengthIcon);
        mstrIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mstrIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.strengthen).getConstantState()){
                    mstrIcon.setImageResource(R.drawable.nostrengthen);
                }else{
                    mstrIcon.setImageResource(R.drawable.strengthen);
                }
            }
        });
        final ImageView mPoisIcon = v.findViewById(R.id.poisonIcon);
        mPoisIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mPoisIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.poison).getConstantState()){
                    mPoisIcon.setImageResource(R.drawable.nopoison);
                }else{
                    mPoisIcon.setImageResource(R.drawable.poison);
                }
            }
        });
        final ImageView mWoundIcon = v.findViewById(R.id.woundIcon);
        mWoundIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mWoundIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.wound).getConstantState()){
                    mWoundIcon.setImageResource(R.drawable.nowound);
                }else{
                    mWoundIcon.setImageResource(R.drawable.wound);
                }
            }
        });
        final ImageView mImmobIcon = v.findViewById(R.id.immobilizeIcon);
        mImmobIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mImmobIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.immobilize).getConstantState()){
                    mImmobIcon.setImageResource(R.drawable.noimmobilize);
                }else{
                    mImmobIcon.setImageResource(R.drawable.immobilize);
                }
            }
        });
        final ImageView mDisarmIcon = v.findViewById(R.id.disarmIcon);
        mDisarmIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mDisarmIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.disarm).getConstantState()){
                    mDisarmIcon.setImageResource(R.drawable.nodisarm);
                }else{
                    mDisarmIcon.setImageResource(R.drawable.disarm);
                }
            }
        });
        final ImageView mStunIcon = v.findViewById(R.id.stunIcon);
        mStunIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mStunIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.stun).getConstantState()){
                    mStunIcon.setImageResource(R.drawable.nostun);
                }else{
                    mStunIcon.setImageResource(R.drawable.stun);
                }
            }
        });
        final ImageView mMuddleIcon = v.findViewById(R.id.muddleIcon);
        mMuddleIcon.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(mMuddleIcon.getDrawable().getConstantState() ==getResources().getDrawable(R.drawable.muddle).getConstantState()){
                    mMuddleIcon.setImageResource(R.drawable.nomuddle);
                }else{
                    mMuddleIcon.setImageResource(R.drawable.muddle);
                }
            }
        });
        final TextView mCurseCount = v.findViewById(R.id.curseCount);
        final TextView mBlessCount = v.findViewById(R.id.blessCount);
        mCurseUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int curses = Integer.parseInt(mCurseCount.getText().toString());
                if(curses < 10){
                    mCallback.addCurse();
                    curses += 1;
                    mCurseCount.setText(Integer.toString(curses));
                }else{
                    if(toast !=null){
                        toast.cancel();
                    }
                    toast = Toast.makeText(getActivity(), "Maximum 10 Curses in Deck", Toast.LENGTH_SHORT);
                    toast.show();
                }
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
                int blesses = Integer.parseInt(mBlessCount.getText().toString());
                if(blesses < 10){
                    mCallback.addBless();
                    blesses += 1;
                    mBlessCount.setText(Integer.toString(blesses));
                }else{
                    if(toast !=null){
                        toast.cancel();
                    }
                    toast = Toast.makeText(getActivity(), "Maximum 10 Blessings in Deck", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        mBlessDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int blesses = Integer.parseInt(mBlessCount.getText().toString());
                if(blesses > 0){
                    mCallback.subBless();
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
