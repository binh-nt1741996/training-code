//package com.selfCheckOut;

import java.util.HashMap;
import java.util.HashSet;

public class product {
    
    private int price;
    private String code;
    private String type;
    private static HashMap<String, Integer> productDB = new HashMap<String, Integer>();

    public void setPrice(int price){
        this.price = price;
        productDB.put(getCode(), price);
    }

    public int getPrice(String code){
        return productDB.get(code);
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public HashMap<String, Integer> getDataBase(){
        return productDB;
    }
}
