package com.ict376.tym.ghattack;

public class GHCard {
    private int name;
    private boolean shuffle, draw;
    public GHCard(int name, boolean shuffle, boolean draw){
        this.name = name; this.shuffle = shuffle; this.draw = draw;
    }
    public int getName(){return name;}
    public Boolean getShuffle(){return shuffle;}
    public Boolean getDraw(){return draw;}

}
