package com.example.demo.trash;

public class player {

    private int fruit = 0;
    private int pillarCount = 0;
    private int revive = 0;

    public void run(){

    }

    public void flip(){

    }

    public void collect(){
        fruit++;
    }

    public void fall(){

    }

    public void reachedPillar(){
        pillarCount ++ ;
    }

    public int getFruit() {
        return fruit;
    }

    public void setFruit(int fruit) {
        this.fruit = fruit;
    }

    public int getPillarCount() {
        return pillarCount;
    }

    public void setPillarCount(int pillarCount) {
        this.pillarCount = pillarCount;
    }

    public int getRevive() {
        return revive;
    }

    public void setRevive(int revive) {
        this.revive = revive;
    }

    public void revive(){
        //revive if appropriate no of fruits is available
        revive++;
        //if available then deduct score appropriately
    }
}
