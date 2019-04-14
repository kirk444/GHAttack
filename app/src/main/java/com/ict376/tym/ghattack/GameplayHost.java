package com.ict376.tym.ghattack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GameplayHost extends Activity implements gp_bottom.OnHeadlineSelectedListener, gp_top.OnHeadlineSelectedListener{
    gp_bottom gp_bot = gp_bottom.newInstance();
    gp_drawlist gp_list = gp_drawlist.newInstance();
    gp_top gp_Top = gp_top.newInstance();
    MediaPlayer shufflePlayer;
    MediaPlayer dealPlayer;
    ArrayList<Integer> stdCards;
    Stack deck = new Stack();
    boolean shuffle = false;
    String selectedClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay_host);
        FragmentManager fragMan = getFragmentManager();
        Intent intent = getIntent();
        stdCards = intent.getIntegerArrayListExtra("CardList");
        selectedClass = intent.getStringExtra("class");
        for(int i = stdCards.size(); i < 20; i++){
            stdCards.add(0);
        }
        shufflePlayer = MediaPlayer.create(this, R.raw.shuffle_short);
        dealPlayer = MediaPlayer.create(this, R.raw.dealloud);
        fragMan.beginTransaction().add(R.id.topFrag_container, gp_Top, "GPTOP").commit();
        fragMan.beginTransaction().add(R.id.ListFrag_container, gp_list, "GPLIST").commit();
        fragMan.beginTransaction().add(R.id.bottomFrag_container, gp_bot, "GPBOT").commit();
        deck = DeckMaker.createDeck(selectedClass, stdCards);
    }
    public void drawCard(){
        dealPlayer.release();
        dealPlayer = MediaPlayer.create(this, R.raw.dealloud);
        dealPlayer.start();
        if(deck.isEmpty()){
            gp_list.addCard(R.drawable.blackback);
            Toast toast = Toast.makeText(this, "Deck Shuffled", Toast.LENGTH_SHORT);
            toast.show();
            gp_list.changeColor(R.color.colorPrimaryDark, R.drawable.lightback);
            deck = DeckMaker.createDeck(selectedClass, stdCards);
        }else{
            GHCard drawn = (GHCard)deck.pop();
            if(drawn.getName() == R.drawable.bless){
                if(stdCards.get(18) > 0){
                    stdCards.set(18, stdCards.get(18)-1);
                    gp_Top.UpdateBless(-1);
                    Log.d("Blesses", Integer.toString(stdCards.get(18)));
                }
            }
            if(drawn.getName() == R.drawable.curse){
                if(stdCards.get(19) > 0){
                    stdCards.set(19, stdCards.get(19)-1);
                    gp_Top.UpdateCurse(-1);
                    Log.d("Curses", Integer.toString(stdCards.get(19)));
                }
            }
            if(drawn.getShuffle()){
                gp_list.changeColor(R.color.shufflenow, R.drawable.lightback);
            }
            gp_list.addCard(drawn.getName());
        }
        gp_bot.updateCards(deck.size());
    }
    public void addCurse(){
        GHCard curse = new GHCard(R.drawable.curse, false, false);
        deck.push(curse);
        Collections.shuffle(deck);
        stdCards.set(19, stdCards.get(19)+1);
        gp_bot.updateCards(deck.size());
    }
    public void subCurse(){
        Stack tempDeck = new Stack();
        boolean found = false;
        if(stdCards.get(19) != 0) {
            do {
                GHCard checkThis = (GHCard) deck.pop();
                if (checkThis.getName() == R.drawable.curse && found == false) {
                    found = true;
                    stdCards.set(19, stdCards.get(19) - 1);
                } else {
                    tempDeck.push(checkThis);
                }
            } while (!deck.isEmpty());
            deck = tempDeck;
            Collections.shuffle(deck);
            gp_bot.updateCards(deck.size());
        }
    }
    public void addBless(){
        GHCard bless = new GHCard(R.drawable.bless, false, false);
        deck.push(bless);
        Collections.shuffle(deck);
        stdCards.set(18, stdCards.get(18)+1);
        gp_bot.updateCards(deck.size());
    }
    public void subBless(){
        if(stdCards.get(18) != 0) {
            Stack tempDeck = new Stack();
            boolean found = false;
            do {
                GHCard checkThis = (GHCard) deck.pop();
                if (checkThis.getName() == R.drawable.bless && !found) {
                    found = true;
                    stdCards.set(18, stdCards.get(18) - 1);
                } else {
                    tempDeck.push(checkThis);
                }
            } while (!deck.isEmpty());
            deck = tempDeck;
            Collections.shuffle(deck);
            gp_bot.updateCards(deck.size());
        }
    }
    public void shuffleDeck(){
        shufflePlayer.release();
        shufflePlayer = MediaPlayer.create(this, R.raw.shuffle_short);
        shufflePlayer.start();
        gp_list.changeColor(R.color.colorPrimaryDark, R.drawable.lightback);
        gp_list.addCard(R.drawable.blackback);
        deck = DeckMaker.createDeck(selectedClass, stdCards);
        gp_bot.updateCards(deck.size());
    }
}
