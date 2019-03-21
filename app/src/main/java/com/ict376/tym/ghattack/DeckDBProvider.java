package com.ict376.tym.ghattack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeckDBProvider extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "DeckDB";
    private static final String DECK_TABLE_NAME = "deck";
    private static final String DECK_ID = "id";
    private static final String DECK_ZERO = "zero";
    private static final String DECK_PLUSONE = "plusone";
    private static final String DECK_NEGONE = "negone";
    private static final String DECK_PLUSTWO = "plustwo";
    private static final String DECK_NEGTWO = "negtwo";
    private static final String DECK_CRIT = "crit";
    private static final String DECK_MISS = "miss";
    private static final String DECK_CARDA = "carda";
    private static final String DECK_CARDB = "cardb";
    private static final String DECK_CARDC = "cardc";
    private static final String DECK_CARDD = "cardd";
    private static final String DECK_CARDE = "carde";
    private static final String DECK_CARDF = "cardf";

    public DeckDBProvider(Context context){super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table " + DECK_TABLE_NAME + "("+
                        DECK_ID + " interger primary key, "+
                        DECK_ZERO + " interger, " +
                        DECK_PLUSONE + " interger, " +
                        DECK_NEGONE + " interger, " +
                        DECK_PLUSTWO + " interger, " +
                        DECK_NEGTWO + " interger, " +
                        DECK_CRIT + " interger, " +
                        DECK_MISS + " interger, " +
                        DECK_CARDA + " interger, " +
                        DECK_CARDB + " interger, " +
                        DECK_CARDC + " interger, " +
                        DECK_CARDD + " interger, " +
                        DECK_CARDE + " interger, " +
                        DECK_CARDF + " interger) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+DECK_TABLE_NAME);
    }
}

