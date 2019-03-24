package com.ict376.tym.ghattack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {
    private Context mContext;
    private int[] icon;
    private ArrayList<Integer> counter = new ArrayList<>();


    public CardAdapter(Context context, ArrayList<Integer> inCounter, int[] inImage){
        counter = inCounter;
        mContext = context;
        icon = inImage;
    }
    public int getCount(){return counter.size();}
    public Object getItem(int arg0){return null;}
    public long getItemId(int position){return position;}
    public int getCardCount(){
        int cardCount = 0;
        for(int i = 0; i < counter.size(); i++){
            cardCount += counter.get(i);
        }
        return cardCount;
    }
    public ArrayList<Integer> getCounter(){return counter;}
    public View getView(int position, View v, ViewGroup parent){
        final int pos = position;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row;
        row = inflater.inflate(R.layout.row_cardnum, parent, false);
        final TextView counterNum = row.findViewById(R.id.listText);
        counterNum.setText(Integer.toString(counter.get(position)));
        ImageView cardIcon = row.findViewById(R.id.listIcon);
        cardIcon.setImageResource((icon[position]));
        Button mPlus = row.findViewById(R.id.plusBut);
        mPlus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                counter.set(pos, counter.get(pos)+1);
                counterNum.setText(Integer.toString(counter.get(pos)));
            }
        });
        Button mMinus = row.findViewById(R.id.minusBut);
        mMinus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                counter.set(pos, counter.get(pos)-1);
                counterNum.setText(Integer.toString(counter.get(pos)));
            }
        });
        return row;
    }

}
