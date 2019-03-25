package com.ict376.tym.ghattack;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class MM_list extends ListFragment {
    private ListView mCardList;
    final Handler handler = new Handler();
    MM_list.OnHeadlineSelectedListener mCallback;
    CardAdapter adapter;
    int[] savedCards = {6,5,5,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
    int [] cards = {R.drawable.zero,R.drawable.pos1, R.drawable.neg1,
            R.drawable.pos2, R.drawable.neg2, R.drawable.crit, R.drawable.miss,
            R.drawable.carda, R.drawable.cardb, R.drawable.cardc, R.drawable.cardd,
            R.drawable.carde, R.drawable.cardf, R.drawable.cardg, R.drawable.cardh, R.drawable.cardi, R.drawable.cardj};
    ArrayList <Integer> cardsNum = new ArrayList<Integer>();
    public MM_list(){}

    public static MM_list NewInstance(){

        MM_list fragment = new MM_list();
        return fragment;
    }
    public static MM_list NewInstance(int[] inCards){
        MM_list fragment = new MM_list();
        Bundle args = new Bundle();
        args.putIntArray("savedCards", inCards);
        fragment.setArguments(args);
        return fragment;
    }
    public interface OnHeadlineSelectedListener{
        void changeDeckNum(int inCardCount);
    }
    @Override
    public void onAttach(Context context){ //Sets up the interface
        super.onAttach(context);
        try {
            mCallback = (MM_list.OnHeadlineSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mm_list, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        if(getArguments() != null){
            if(getArguments().getIntArray("savedCards") != null){
                savedCards = getArguments().getIntArray("savedCards");
            }
        }
        for(int i = 0; i < savedCards.length; i++){
            cardsNum.add(savedCards[i]);
        }
        mCardList = v.findViewById(R.id.CardList);
        adapter = new CardAdapter(getView().getContext(), cardsNum, cards);
        mCardList.setAdapter(adapter);
        startCounting();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        handler.removeMessages(0);
    }
    public ArrayList<Integer> getCards(){
        return adapter.getCounter();
    }

    public void updateList(int[] inCards){
        ArrayList <Integer> cardsNum = new ArrayList<Integer>();
        savedCards = inCards;
        for(int i = 0; i < savedCards.length; i++){
            cardsNum.add(savedCards[i]);
        }

        mCardList = getView().findViewById(R.id.CardList);
        adapter = new CardAdapter(getView().getContext(), cardsNum, cards);
        adapter.notifyDataSetChanged();
        mCardList.setAdapter(adapter);

    }
    public void updateList(){
        ArrayList <Integer> cardsNum = new ArrayList<Integer>();
        for(int i = 0; i < savedCards.length; i++){
            cardsNum.add(savedCards[i]);
        }
        mCardList = getView().findViewById(R.id.CardList);
        adapter = new CardAdapter(getView().getContext(), cardsNum, cards);
        mCardList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void startCounting() {

        handler.post(new Runnable() {
            @Override
            public void run() {
                mCallback.changeDeckNum(adapter.getCardCount());
                handler.postDelayed(this, 100);
            }
        });
    }
    public void updateClass(String inClass){
        switch(inClass){
            case "Brute":
                cards[7] = R.drawable.br_pos3;
                cards[8] = R.drawable.br_addpush;
                cards[9] = R.drawable.br_addpierce;
                cards[10] = R.drawable.br_addstun;
                cards[11] = R.drawable.br_adddisarm;
                cards[12] = R.drawable.br_addmuddle;
                cards[13] = R.drawable.br_addtarg;
                cards[14] = R.drawable.br_pos1shield;
                cards[15] = R.drawable.carda;
                cards[16] = R.drawable.cardb;
                updateList();
                break;
            case "Spellweaver":
                cards[7] = R.drawable.sw_stun;
                cards[8] = R.drawable.sw_pos1wound;
                cards[9] = R.drawable.sw_pos1imm;
                cards[10] = R.drawable.sw_pos1curse;
                cards[11] = R.drawable.sw_pos2fire;
                cards[12] = R.drawable.sw_pos2ice;
                cards[13] = R.drawable.sw_addnature;
                cards[14] = R.drawable.sw_addwind;
                cards[15] = R.drawable.sw_addsun;
                cards[16] = R.drawable.sw_adddark;
                updateList();
                break;
            case "Scoundrel":
                cards[7] = R.drawable.sc_addpos1;
                cards[8] = R.drawable.sc_addpierce;
                cards[9] = R.drawable.sc_addposion;
                cards[10] = R.drawable.sc_addmuddle;
                cards[11] = R.drawable.sc_addinvis;
                cards[12] = R.drawable.carda;
                cards[13] = R.drawable.cardb;
                cards[14] = R.drawable.cardc;
                cards[15] = R.drawable.cardd;
                cards[16] = R.drawable.carde;
                updateList();
                break;
            case "Spears":
                cards[7] = R.drawable.sp_addpos1;
                cards[8] = R.drawable.sp_addmuddle;
                cards[9] = R.drawable.sp_addpierce;
                cards[10] = R.drawable.sp_addstun;
                cards[11] = R.drawable.sp_addtarg;
                cards[12] = R.drawable.sp_refresh;
                cards[13] = R.drawable.carda;
                cards[14] = R.drawable.cardb;
                cards[15] = R.drawable.cardc;
                cards[16] = R.drawable.cardd;
                updateList();
                break;

        }
    }
}
