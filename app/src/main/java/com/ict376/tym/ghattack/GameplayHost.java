package com.ict376.tym.ghattack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Collections;
import java.util.Stack;

public class GameplayHost extends Activity implements gp_bottom.OnHeadlineSelectedListener{
    gp_bottom gp_bot = gp_bottom.newInstance();
    gp_drawlist gp_list = gp_drawlist.newInstance();
    gp_top gp_Top = gp_top.newInstance();
    int[] stdCards;
    Stack deck = new Stack();
    boolean shuffle = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay_host);
        FragmentManager fragMan = getFragmentManager();
        Intent intent = getIntent();
        stdCards = intent.getIntArrayExtra("CardList");
        fragMan.beginTransaction().add(R.id.topFrag_container, gp_Top, "GPTOP").commit();
        fragMan.beginTransaction().add(R.id.ListFrag_container, gp_list, "GPLIST").commit();
        fragMan.beginTransaction().add(R.id.bottomFrag_container, gp_bot, "GPBOT").commit();
        createDeck();
    }
    public void drawCard(){
        MediaPlayer mediaplayer = MediaPlayer.create(this, R.raw.deal);
        if(deck.isEmpty()){
            gp_list.addCard(R.drawable.blackback);
            Toast toast = Toast.makeText(this, "Deck Shuffled", Toast.LENGTH_SHORT);
            toast.show();
            gp_list.changeColor(Color.WHITE);
            createDeck();
        }else{
            GHCard drawn = (GHCard)deck.pop();
            if(drawn.getShuffle()){
                gp_list.changeColor(Color.BLACK);
            }
            gp_list.addCard(drawn.getName());
        }

    }
    public void shuffleDeck(){
        gp_list.changeColor(Color.WHITE);
        gp_list.addCard(R.drawable.blackback);
        createDeck();
    }
    public void createDeck(){
        deck.clear();
        for(int i = 0; i < stdCards.length; i++){
            for(int j = 0; j < stdCards[i]; j++){
                switch(i){
                    case 0:
                        GHCard zero = new GHCard(R.drawable.zero, false, false, Color.WHITE);
                        deck.push(zero);
                        break;

                    case 1:
                        GHCard plus1 = new GHCard(R.drawable.pos1, false, false, Color.GREEN);
                        deck.push(plus1);
                        break;
                    case 2:
                        GHCard neg1 = new GHCard(R.drawable.neg1, false, false, Color.RED);
                        deck.push(neg1);
                        break;
                    case 3:
                        GHCard plus2 = new GHCard(R.drawable.pos2, false, false, Color.GREEN);
                        deck.push(plus2);
                        break;
                    case 4:
                        GHCard neg2 = new GHCard(R.drawable.neg2, false, false, Color.RED);
                        deck.push(neg2);
                        break;
                    case 5:
                        GHCard crit = new GHCard(R.drawable.crit, true, false, Color.MAGENTA);
                        deck.push(crit);
                        break;
                    case 6:
                        GHCard miss = new GHCard(R.drawable.miss, true, false, Color.YELLOW);
                        deck.push(miss);
                        break;
                    case 7:
                        GHCard cardA = new GHCard(R.drawable.carda, false, false, Color.BLUE);
                        deck.push(cardA);
                        break;
                    case 8:
                        GHCard cardB = new GHCard(R.drawable.cardb, false, false, Color.BLUE);
                        deck.push(cardB);
                        break;
                    case 9:
                        GHCard cardC = new GHCard(R.drawable.cardc, false, false, Color.BLUE);
                        deck.push(cardC);
                        break;
                    case 10:
                        GHCard cardD = new GHCard(R.drawable.cardd, false, false, Color.BLUE);
                        deck.push(cardD);
                        break;
                    case 11:
                        GHCard cardE = new GHCard(R.drawable.carde, false, false, Color.BLUE);
                        deck.push(cardE);
                        break;
                    case 12:
                        GHCard cardF = new GHCard(R.drawable.cardf, false, false, Color.BLUE);
                        deck.push(cardF);
                        break;
                }
                Collections.shuffle(deck);
            }
        }
    }
}
