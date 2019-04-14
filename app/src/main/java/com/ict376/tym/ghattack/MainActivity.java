package com.ict376.tym.ghattack;

import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MM_bottom.OnHeadlineSelectedListener, MM_list.OnHeadlineSelectedListener, MM_top.OnHeadlineSelectedListener {
    private MM_bottom mm_bot;
    private MM_list mm_list;
    private MM_top mm_top;
    private int[] defaultDeck = {6,5,5,1,1,1,1,0,0,0,0,0,0,0,0,0,0};
    private String selected = "Default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragMan = getFragmentManager();
        mm_bot = MM_bottom.NewInstance();
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
        intent.putExtra("class", selected);
        startActivity(intent);
    }
    public void changeDeckNum(int inNum){
        mm_bot.updateCardNum(inNum);
    }
    public void reset(){
        mm_list.updateList(defaultDeck);
    }
    public void classChange(String inClass){
        mm_list.updateClass(inClass);
        selected = inClass;
    }
    public void save(){
        ArrayList<Integer> convertThis = mm_list.getCards();
        int[] saveThis = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i < convertThis.size(); i++){
            saveThis[i] = convertThis.get(i);
        }
        DeckDBProvider deckDB = new DeckDBProvider(this);
        if(deckDB.checkDeck(selected)){
            deckDB.deleteThis(selected);
        }
        boolean success = deckDB.addClass(selected, saveThis);
        if(success){
            Toast toast = Toast.makeText(this, selected+" saved", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    public void load(){
        DeckDBProvider deckDB = new DeckDBProvider(this);
        if(deckDB.checkDeck(selected)){
            int[] loadedDeck = deckDB.getCards(selected);
            mm_list.updateList(loadedDeck);
        }else{
            Toast toast = Toast.makeText(this, "No saved data", Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
