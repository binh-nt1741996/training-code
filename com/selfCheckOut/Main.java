//package com.selfCheckOut;

public class Main {
    public static void main(String[] args) {
        String[] input = new String[]{"2", "001137565660 1000", "78722" 
                                        , "start", "0011375656600", "0278722020000", "end"
                                        , "start", "0011375656600", "0278722020002", "end"};

        order firstOder = new order();
        firstOder.getOrder(input);
        firstOder.getCustomer();
    }
}