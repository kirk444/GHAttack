package com.ict376.tym.ghattack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GPCardAdapter extends BaseAdapter {
    private Context mContext;
    private List<Integer> cards = new ArrayList();
    public GPCardAdapter(Context context, List<Integer> inImage){
        mContext = context;
        cards = inImage;
    }
    public int getCount(){return cards.size();}
    public Object getItem(int arg0){return null;}
    public long getItemId(int position){return position;}
    public void addItem(int inImage){
        cards.add(inImage);
    }
    public View getView(int position, View v, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row;
        row = inflater.inflate(R.layout.row_pictureonly, parent, false);
        ImageView icon = row.findViewById(R.id.drawnCard);
        icon.setImageResource((cards.get(position)));
        return row;
    }
}
