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
        createDeck(selectedClass);
    }
    public void drawCard(){
        dealPlayer.release();
        dealPlayer = MediaPlayer.create(this, R.raw.dealloud);
        dealPlayer.start();
        if(deck.isEmpty()){
            gp_list.addCard(R.drawable.blackback);
            Toast toast = Toast.makeText(this, "Deck Shuffled", Toast.LENGTH_SHORT);
            toast.show();
            gp_list.changeColor(R.color.colorPrimaryDark);
            createDeck(selectedClass);
        }else{
            GHCard drawn = (GHCard)deck.pop();
            if(drawn.getName() == R.drawable.bless){
                if(stdCards.get(18) > 0){
                    stdCards.set(18, stdCards.get(18)-1);
                    gp_Top.UpdateBless(-1);
                }
            }
            if(drawn.getName() == R.drawable.curse){
                if(stdCards.get(19) > 0){
                    stdCards.set(19, stdCards.get(19)-1);
                    gp_Top.UpdateCurse(-1);
                }
            }
            if(drawn.getShuffle()){
                gp_list.changeColor(Color.WHITE);
            }
            gp_list.addCard(drawn.getName());
        }

    }
    public void addCurse(){
        GHCard curse = new GHCard(R.drawable.curse, false, false);
        deck.push(curse);
        Collections.shuffle(deck);
        stdCards.set(19, stdCards.get(19)+1);
    }
    public void subCurse(){
        Stack tempDeck = new Stack();
        boolean found = false;
        do{
            GHCard checkThis = (GHCard)deck.pop();
            if(checkThis.getName() == R.drawable.curse && found == false){
                found = true;
                stdCards.set(19, stdCards.get(19)-1);
            }else{
                tempDeck.push(checkThis);
            }
        }while(!deck.isEmpty());
        deck = tempDeck;
        Collections.shuffle(deck);
    }
    public void addBless(){
        GHCard bless = new GHCard(R.drawable.bless, false, false);
        deck.push(bless);
        Collections.shuffle(deck);
        stdCards.set(18, stdCards.get(18)+1);
    }
    public void subBless(){
        Stack tempDeck = new Stack();
        boolean found = false;
        do{
            GHCard checkThis = (GHCard)deck.pop();
            if(checkThis.getName() == R.drawable.bless && !found){
                found = true;
                stdCards.set(18, stdCards.get(18) - 1);
            }else{
                tempDeck.push(checkThis);
            }
        }while(!deck.isEmpty());
        deck = tempDeck;
        Collections.shuffle(deck);
    }
    public void shuffleDeck(){
        shufflePlayer.release();
        shufflePlayer = MediaPlayer.create(this, R.raw.shuffle_short);
        shufflePlayer.start();
        gp_list.changeColor(R.color.colorPrimaryDark);
        gp_list.addCard(R.drawable.blackback);
        createDeck(selectedClass);
    }
    public void createDeck(String inClass){
        deck.clear();
        ArrayList<GHCard> classDeck = new ArrayList<>();
        GHCard tempcard = new GHCard(R.drawable.zero, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.pos1, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.neg1, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.pos2, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.neg2, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.crit, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.miss, false, false);
        classDeck.add(tempcard);
        switch(inClass){
            case "Brute":
                tempcard = new GHCard(R.drawable.br_pos3, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_addpush, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_addpierce, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_adddisarm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_addtarg, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.br_pos1shield, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carda, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardb, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardc, false, false);
                classDeck.add(tempcard);
                break;
            case "Spellweaver":
                tempcard = new GHCard(R.drawable.sw_stun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_pos1wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_pos1curse, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_pos2fire, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_pos2ice, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_addnature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_addwind, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_addsun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sw_adddark, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carda, false, false);
                classDeck.add(tempcard);
                break;
            case "Scoundrel":
                tempcard = new GHCard(R.drawable.sc_addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sc_addpierce, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sc_addposion, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sc_addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sc_addinvis, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carda, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardb, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardc, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardd, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carde, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardf, false, false);
                classDeck.add(tempcard);
                break;
            case "Spears":
                tempcard = new GHCard(R.drawable.sp_addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sp_addmuddle, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sp_addpierce, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sp_addstun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sp_addtarg, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.sp_refresh, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carda, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardb, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardc, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardd, false, false);
                classDeck.add(tempcard);
            default:
                tempcard = new GHCard(R.drawable.carda, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardb, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardc, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardd, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.carde, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardf, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardg, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardh, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardi, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.cardj, false, false);
                classDeck.add(tempcard);
        }
        tempcard = new GHCard(R.drawable.bless, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.curse, false, false);
        classDeck.add(tempcard);
        for(int i = 0; i < stdCards.size(); i++){
            for(int j = 0; j < stdCards.get(i); j++){
                switch(i){
                    case 0:
                        deck.push(classDeck.get(0));
                        break;
                    case 1:
                        deck.push(classDeck.get(1));
                        break;
                    case 2:
                        deck.push(classDeck.get(2));
                        break;
                    case 3:
                        deck.push(classDeck.get(3));
                        break;
                    case 4:
                        deck.push(classDeck.get(4));
                        break;
                    case 5:
                        deck.push(classDeck.get(5));
                        break;
                    case 6:
                        deck.push(classDeck.get(6));
                        break;
                    case 7:
                        deck.push(classDeck.get(7));
                        break;
                    case 8:
                        deck.push(classDeck.get(8));
                        break;
                    case 9:
                        deck.push(classDeck.get(9));
                        break;
                    case 10:
                        deck.push(classDeck.get(10));
                        break;
                    case 11:
                        deck.push(classDeck.get(11));
                        break;
                    case 12:
                        deck.push(classDeck.get(12));
                        break;
                    case 13:
                        deck.push(classDeck.get(13));
                        break;
                    case 14:
                        deck.push(classDeck.get(14));
                        break;
                    case 15:
                        deck.push(classDeck.get(15));
                        break;
                    case 16:
                        deck.push(classDeck.get(16));
                        break;
                    case 17:
                        deck.push(classDeck.get(17));
                        break;
                    case 18:
                        deck.push(classDeck.get(18));
                        break;
                    case 19:
                        deck.push(classDeck.get(19));
                        break;
                }
                Collections.shuffle(deck);
            }
        }
    }
}
