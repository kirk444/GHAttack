package com.ict376.tym.ghattack;


import android.app.ListFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class gp_drawlist extends ListFragment {
    private ListView mdrawList;
    private List<Integer> deckList = new ArrayList();

    public gp_drawlist() {
        // Required empty public constructor
    }

    public static gp_drawlist newInstance(){
        gp_drawlist gp_list = new gp_drawlist();
        return gp_list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gp_drawlist, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        mdrawList = v.findViewById(R.id.drawList);
        deckList.add(R.drawable.back);
        GPCardAdapter adapter = new GPCardAdapter(getView().getContext(), deckList);
        mdrawList.setAdapter(adapter);
        changeColor(R.color.colorPrimaryDark);
    }
    public void addCard(int inCard){
        deckList.add(0, inCard);
        GPCardAdapter adapter = new GPCardAdapter(getView().getContext(), deckList);
        mdrawList.setAdapter(adapter);
    }
    public void changeColor(int inColor){
        getView().setBackgroundColor(inColor);
    }

}
