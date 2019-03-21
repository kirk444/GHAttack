package com.ict376.tym.ghattack;

public class GHCard {
    private int name;
    private boolean shuffle, draw;
    private int cardColor;
    public GHCard(int name, boolean shuffle, boolean draw, int cardColor){
        this.name = name; this.shuffle = shuffle; this.draw = draw; this.cardColor = cardColor;
    }
    public int getName(){return name;}
    public Boolean getShuffle(){return shuffle;}
    public Boolean getDraw(){return draw;}
    public int getColor(){return cardColor;}

}
