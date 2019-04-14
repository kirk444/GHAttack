package com.ict376.tym.ghattack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DeckMaker {
    public static Stack createDeck(String inClass, ArrayList<Integer> stdCards) {
        Stack<GHCard> deck = new Stack<GHCard>();
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
        tempcard = new GHCard(R.drawable.crit, true, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.miss, true, false);
        classDeck.add(tempcard);
        switch (inClass) {
            case "Brute":
                tempcard = new GHCard(R.drawable.pos3, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpush1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpierce3, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.adddisarm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addtarg, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1shield, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Spellweaver":
                tempcard = new GHCard(R.drawable.zerostun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1curse, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2fire, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2ice, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addnature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addwind, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addsun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.adddark, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Scoundrel":
                tempcard = new GHCard(R.drawable.addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpierce3, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpois, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addinvis, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Three Spears":
                tempcard = new GHCard(R.drawable.addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpierce3, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addtarg, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerorefresh, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Custom":
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
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Cthulu":
                tempcard = new GHCard(R.drawable.pos1wind, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpois, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addcurse, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addimm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Tinkerer":
                tempcard = new GHCard(R.drawable.pos3, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addfire, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1heal2, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerotarg, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Mindthief":
                tempcard = new GHCard(R.drawable.pos2ice, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpos1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpull1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addimm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.adddisarm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Sun":
                tempcard = new GHCard(R.drawable.addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addlight, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addshield1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Two Minis":
                tempcard = new GHCard(R.drawable.pos1wound, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addnature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Cragheart":
                tempcard = new GHCard(R.drawable.pos1imm, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2muddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpush2, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addnature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addwind, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Circles":
                tempcard = new GHCard(R.drawable.addwound, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpois, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addfire, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addwind, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.adddark, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addnature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Triforce":
                tempcard = new GHCard(R.drawable.zerofire, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zeroice, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerowind, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zeronature, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1push1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerostun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerotarg, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Lightning Bolt":
                tempcard = new GHCard(R.drawable.addpos2, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addwound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpos1disarm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2fire, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Angry Face":
                tempcard = new GHCard(R.drawable.addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2muddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1poison, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerostun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addtarg, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Eclipse":
                tempcard = new GHCard(R.drawable.neg1dark, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1dark, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1invis, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addmuddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal1, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addcurse, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addtarg, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Saw":
                tempcard = new GHCard(R.drawable.addpos2, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addwound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addstun, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addheal3, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerorefresh, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
            case "Music Note":
                tempcard = new GHCard(R.drawable.pos4, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1imm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos1disarm, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2wound, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2poison, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos2curse, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.pos3muddle, false, true);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.zerostun, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addpos1, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.addcurse, false, false);
                classDeck.add(tempcard);
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
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
                tempcard = new GHCard(R.drawable.skip, false, false);
                classDeck.add(tempcard);
                break;
        }
        tempcard = new GHCard(R.drawable.bless, false, false);
        classDeck.add(tempcard);
        tempcard = new GHCard(R.drawable.curse, false, false);
        classDeck.add(tempcard);
        for (int i = 0; i < stdCards.size(); i++) {
            for (int j = 0; j < stdCards.get(i); j++) {
                switch (i) {
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

            }
        }
        Collections.shuffle(deck);
        return deck;
    }
    public static int[] updateDeck(int[] cards, String inClass){
        switch(inClass){
            case "Brute":
                cards[7] = R.drawable.pos3;
                cards[8] = R.drawable.addpush1;
                cards[9] = R.drawable.addpierce3;
                cards[10] = R.drawable.addstun;
                cards[11] = R.drawable.adddisarm;
                cards[12] = R.drawable.addmuddle;
                cards[13] = R.drawable.addtarg;
                cards[14] = R.drawable.pos1shield;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Spellweaver":
                cards[7] = R.drawable.zerostun;
                cards[8] = R.drawable.pos1wound;
                cards[9] = R.drawable.pos1imm;
                cards[10] = R.drawable.pos1curse;
                cards[11] = R.drawable.pos2fire;
                cards[12] = R.drawable.pos2ice;
                cards[13] = R.drawable.addnature;
                cards[14] = R.drawable.addwind;
                cards[15] = R.drawable.addsun;
                cards[16] = R.drawable.adddark;
                break;
            case "Scoundrel":
                cards[7] = R.drawable.addpos1;
                cards[8] = R.drawable.addpierce3;
                cards[9] = R.drawable.addpois;
                cards[10] = R.drawable.addmuddle;
                cards[11] = R.drawable.addinvis;
                cards[12] = R.drawable.skip;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Three Spears":
                cards[7] = R.drawable.addpos1;
                cards[8] = R.drawable.addmuddle;
                cards[9] = R.drawable.addpierce3;
                cards[10] = R.drawable.addstun;
                cards[11] = R.drawable.addtarg;
                cards[12] = R.drawable.zerorefresh;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Angry Face":
                cards[7] = R.drawable.addpos1;
                cards[8] = R.drawable.pos2muddle;
                cards[9] = R.drawable.pos1poison;
                cards[10] = R.drawable.pos1wound;
                cards[11] = R.drawable.pos1imm;
                cards[12] = R.drawable.zerostun;
                cards[13] = R.drawable.addtarg;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Cthulu":
                cards[7] = R.drawable.pos1wind;
                cards[8] = R.drawable.addpois;
                cards[9] = R.drawable.addcurse;
                cards[10] = R.drawable.addimm;
                cards[11] = R.drawable.addstun;
                cards[12] = R.drawable.skip;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Sun":
                cards[7] = R.drawable.addpos1;
                cards[8] = R.drawable.addheal1;
                cards[9] = R.drawable.addstun;
                cards[10] = R.drawable.addlight;
                cards[11] = R.drawable.addshield1;
                cards[12] = R.drawable.skip;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Circles":
                cards[7] = R.drawable.addwound;
                cards[8] = R.drawable.addpois;
                cards[9] = R.drawable.addheal1;
                cards[10] = R.drawable.addfire;
                cards[11] = R.drawable.addwind;
                cards[12] = R.drawable.adddark;
                cards[13] = R.drawable.addnature;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Tinkerer":
                cards[7] = R.drawable.pos3;
                cards[8] = R.drawable.addfire;
                cards[9] = R.drawable.addmuddle;
                cards[10] = R.drawable.pos1wound;
                cards[11] = R.drawable.pos1imm;
                cards[12] = R.drawable.pos1heal2;
                cards[13] = R.drawable.zerotarg;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Cragheart":
                cards[7] = R.drawable.pos1imm;
                cards[8] = R.drawable.pos2muddle;
                cards[9] = R.drawable.addpush2;
                cards[10] = R.drawable.addnature;
                cards[11] = R.drawable.addwind;
                cards[12] = R.drawable.skip;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Mindthief":
                cards[7] = R.drawable.pos2ice;
                cards[8] = R.drawable.addpos1;
                cards[9] = R.drawable.addpull1;
                cards[10] = R.drawable.addmuddle;
                cards[11] = R.drawable.addimm;
                cards[12] = R.drawable.addstun;
                cards[13] = R.drawable.adddisarm;
                cards[14] = R.drawable.addmuddle;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Eclipse":
                cards[7] = R.drawable.neg1dark;
                cards[8] = R.drawable.pos1dark;
                cards[9] = R.drawable.pos1invis;
                cards[10] = R.drawable.addmuddle;
                cards[11] = R.drawable.addheal1;
                cards[12] = R.drawable.addcurse;
                cards[13] = R.drawable.addtarg;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Triforce":
                cards[7] = R.drawable.zerofire;
                cards[8] = R.drawable.zeroice;
                cards[9] = R.drawable.zerowind;
                cards[10] = R.drawable.zeronature;
                cards[11] = R.drawable.pos1push1;
                cards[12] = R.drawable.pos1wound;
                cards[13] = R.drawable.zerostun;
                cards[14] = R.drawable.zerotarg;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Two Minis":
                cards[7] = R.drawable.pos1wound;
                cards[8] = R.drawable.pos1imm;
                cards[9] = R.drawable.addheal1;
                cards[10] = R.drawable.addnature;
                cards[11] = R.drawable.skip;
                cards[12] = R.drawable.skip;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Lightning Bolt":
                cards[7] = R.drawable.addpos2;
                cards[8] = R.drawable.addwound;
                cards[9] = R.drawable.addstun;
                cards[10] = R.drawable.addpos1disarm;
                cards[11] = R.drawable.addheal1;
                cards[12] = R.drawable.pos2fire;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Saw":
                cards[7] = R.drawable.addpos2;
                cards[8] = R.drawable.pos1imm;
                cards[9] = R.drawable.addwound;
                cards[10] = R.drawable.addstun;
                cards[11] = R.drawable.addheal3;
                cards[12] = R.drawable.zerorefresh;
                cards[13] = R.drawable.skip;
                cards[14] = R.drawable.skip;
                cards[15] = R.drawable.skip;
                cards[16] = R.drawable.skip;
                break;
            case "Music Note":
                cards[7] = R.drawable.pos4;
                cards[8] = R.drawable.pos1imm;
                cards[9] = R.drawable.pos1disarm;
                cards[10] = R.drawable.pos2wound;
                cards[11] = R.drawable.pos2poison;
                cards[12] = R.drawable.pos2curse;
                cards[13] = R.drawable.pos3muddle;
                cards[14] = R.drawable.zerostun;
                cards[15] = R.drawable.addpos1;
                cards[16] = R.drawable.addcurse;
                break;
            case "Custom":
                cards[7] = R.drawable.carda;
                cards[8] = R.drawable.cardb;
                cards[9] = R.drawable.cardc;
                cards[10] = R.drawable.cardd;
                cards[11] = R.drawable.carde;
                cards[12] = R.drawable.cardf;
                cards[13] = R.drawable.cardg;
                cards[14] = R.drawable.cardh;
                cards[15] = R.drawable.cardi;
                cards[16] = R.drawable.cardj;
                break;
            default:
                cards[7] = R.drawable.carda;
                cards[8] = R.drawable.cardb;
                cards[9] = R.drawable.cardc;
                cards[10] = R.drawable.cardd;
                cards[11] = R.drawable.carde;
                cards[12] = R.drawable.cardf;
                cards[13] = R.drawable.cardg;
                cards[14] = R.drawable.cardh;
                cards[15] = R.drawable.cardi;
                cards[16] = R.drawable.cardj;
                break;
        }
        return cards;
    }
}

