package com.ict376.tym.ghattack;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MM_list extends ListFragment {
    private ListView mCardList;
    CardAdapter adapter;
    int[] cards= {R.drawable.zero,R.drawable.pos1, R.drawable.neg1,
            R.drawable.pos2, R.drawable.neg2, R.drawable.crit, R.drawable.miss,
            R.drawable.carda, R.drawable.cardb, R.drawable.cardc, R.drawable.cardd,
            R.drawable.carde, R.drawable.cardf};
    int []cardsNum =  {6, 5, 5, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0};

    public MM_list(){}

    public static MM_list NewInstance(){
        MM_list fragment = new MM_list();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mm_list, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        mCardList = v.findViewById(R.id.CardList);
        adapter = new CardAdapter(getView().getContext(), cardsNum, cards);
        mCardList.setAdapter(adapter);
    }
    public int[] getCards(){
        return adapter.getCounter();
    }
}
