package com.ict376.tym.ghattack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Array;

public class DeckDBProvider extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "DeckDB";
    private static final String DECK_TABLE_NAME = "deck";
    private static final String DECK_ID = "id";
    private static final String DECK_CLASS = "class";
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
    private static final String DECK_CARDG = "cardg";
    private static final String DECK_CARDH = "cardh";
    private static final String DECK_CARDI = "cardi";
    private static final String DECK_CARDJ = "cardj";

    public DeckDBProvider(Context context){super(context, DATABASE_NAME, null, 5);}

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(
                "create table " + DECK_TABLE_NAME + "("+
                        DECK_ID + " interger primary key, "+
                        DECK_CLASS + " text, " +
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
                        DECK_CARDF + " interger, " +
                        DECK_CARDG + " interger, " +
                        DECK_CARDH + " interger, " +
                        DECK_CARDI + " interger, " +
                        DECK_CARDJ + " interger) ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+DECK_TABLE_NAME);
        onCreate(db);
    }
    public int[] getCards(String classSelect){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+DECK_TABLE_NAME +" where "+DECK_CLASS+" = '"+classSelect+"'", null);
        res.moveToFirst();
        int[] cards = {res.getInt(res.getColumnIndex(DECK_ZERO)), res.getInt(res.getColumnIndex(DECK_PLUSONE)), res.getInt(res.getColumnIndex(DECK_NEGONE)),
                res.getInt(res.getColumnIndex(DECK_PLUSTWO)), res.getInt(res.getColumnIndex(DECK_NEGTWO)), res.getInt(res.getColumnIndex(DECK_CRIT)),
                        res.getInt(res.getColumnIndex(DECK_MISS)), res.getInt(res.getColumnIndex(DECK_CARDA)), res.getInt(res.getColumnIndex(DECK_CARDB)),
                                res.getInt(res.getColumnIndex(DECK_CARDC)), res.getInt(res.getColumnIndex(DECK_CARDD)), res.getInt(res.getColumnIndex(DECK_CARDE)),
                                        res.getInt(res.getColumnIndex(DECK_CARDF)), res.getInt(res.getColumnIndex(DECK_CARDG)), res.getInt(res.getColumnIndex(DECK_CARDH)),
                                                res.getInt(res.getColumnIndex(DECK_CARDI)), res.getInt(res.getColumnIndex(DECK_CARDJ))};
        res.close();
        return cards;
    }
    public boolean checkDeck(String classSelect){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+DECK_TABLE_NAME, null);
        res.moveToFirst();
        boolean check = false;
        while(!res.isAfterLast()){
            if(res.getString(res.getColumnIndex(DECK_CLASS)).equals(classSelect)){
                check = true;
            };
            res.moveToNext();
        }
        res.close();
        return check;
    }
    public boolean addClass(String classSelect, int[] saveThis){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DECK_CLASS, classSelect);
        cv.put(DECK_ZERO, saveThis[0]);
        cv.put(DECK_PLUSONE, saveThis[1]);
        cv.put(DECK_NEGONE, saveThis[2]);
        cv.put(DECK_PLUSTWO, saveThis[3]);
        cv.put(DECK_NEGTWO, saveThis[4]);
        cv.put(DECK_CRIT, saveThis[5]);
        cv.put(DECK_MISS, saveThis[6]);
        cv.put(DECK_CARDA, saveThis[7]);
        cv.put(DECK_CARDB, saveThis[8]);
        cv.put(DECK_CARDC, saveThis[9]);
        cv.put(DECK_CARDD, saveThis[10]);
        cv.put(DECK_CARDE, saveThis[11]);
        cv.put(DECK_CARDF, saveThis[12]);
        cv.put(DECK_CARDG, saveThis[13]);
        cv.put(DECK_CARDH, saveThis[14]);
        cv.put(DECK_CARDI, saveThis[15]);
        cv.put(DECK_CARDJ, saveThis[16]);
        db.insert(DECK_TABLE_NAME, null, cv);
        Log.d("Check", "Saved");
        return true;
    }
    public void deleteThis(String inClass){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+DECK_TABLE_NAME+" WHERE "+DECK_CLASS+"= '"+inClass+"'");
    }
}

