//package com.selfCheckOut;

import java.util.ArrayList;

public class customer {
    private String pointCardID;
    private int points = 0;
    private ArrayList<String> barCode = new ArrayList<String>();

    public void setID(String pointCardID){
        this.pointCardID = pointCardID;
    }

    public String getID(){
        return this.pointCardID;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public int getPoints(){
        return this.points;
    }

    public void setBarCode(String barCode){
        this.barCode.add(barCode);
    }
    
    public ArrayList<String> getBarCode(){
        return this.barCode;
    }

    public String getBarCode(int index){
        return this.barCode.get(index);
    }
}
