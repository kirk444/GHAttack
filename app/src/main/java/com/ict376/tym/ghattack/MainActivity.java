package com.ict376.tym.ghattack;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MM_bottom.OnHeadlineSelectedListener{
    private MM_bottom mm_bot = MM_bottom.NewInstance();
    private MM_list mm_list = MM_list.NewInstance();
    private MM_top mm_top = MM_top.NewInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragMan = getFragmentManager();
        if(getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Build your Deck");
        }

        fragMan.beginTransaction().add(R.id.topFrag_container, mm_top, "MMTOP").commit();
        fragMan.beginTransaction().add(R.id.ListFrag_container, mm_list, "MMLIST").commit();
        fragMan.beginTransaction().add(R.id.bottomFrag_container, mm_bot, "MMBOT").commit();
    }
    public void startGame(){
        int[] cards = mm_list.getCards();
        Intent intent = new Intent(MainActivity.this, GameplayHost.class);
        intent.putExtra("CardList", cards);
        startActivity(intent);
    }
    public void changeDeckNum(){

    }
}
