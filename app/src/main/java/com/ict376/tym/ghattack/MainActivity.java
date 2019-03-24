package com.ict376.tym.ghattack;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MM_bottom.OnHeadlineSelectedListener, MM_list.OnHeadlineSelectedListener, MM_top.OnHeadlineSelectedListener {
    private MM_bottom mm_bot = MM_bottom.NewInstance();
    private MM_list mm_list;
    private MM_top mm_top;
    private int[] defaultDeck = {6,5,5,1,1,1,1,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragMan = getFragmentManager();
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Build your Deck");
        }
        mm_list = MM_list.NewInstance(defaultDeck);
        mm_top = MM_top.NewInstance();
        fragMan.beginTransaction().add(R.id.topFrag_container, mm_top, "MMTOP").commit();
        fragMan.beginTransaction().add(R.id.ListFrag_container, mm_list, "MMLIST").commit();
        fragMan.beginTransaction().add(R.id.bottomFrag_container, mm_bot, "MMBOT").commit();
    }
    public void startGame(){
        ArrayList<Integer> cards = mm_list.getCards();
        Intent intent = new Intent(MainActivity.this, GameplayHost.class);
        intent.putExtra("CardList", cards);
        startActivity(intent);
    }
    public void changeDeckNum(int inNum){
        mm_top.updateCardNum(inNum);
    }
    public void reset(){
        FragmentManager fragMan = getFragmentManager();
        Fragment frag = fragMan.findFragmentByTag("MMLIST");
        if(frag != null){
            fragMan.beginTransaction().remove(frag).commit();
        }
        mm_list = MM_list.NewInstance(defaultDeck);
        fragMan.beginTransaction().add(R.id.ListFrag_container, mm_list, "MMLIST").commit();
    }
}
