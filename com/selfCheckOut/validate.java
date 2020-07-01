//package com.selfCheckOut;

import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Map;

public class validate {

    public static boolean checkCheckSum(String barCode){
        int sum = 0;
        int len = barCode.length();

        int[] code = new int[len - 1];
        for (int i = 0; i < code.length; i++){
            char c = barCode.charAt(i);
            code[i] = Integer.parseInt(String.valueOf(c));
        }
        int checksum = Integer.parseInt(String.valueOf(barCode.charAt(len - 1)));
        boolean result = (IntStream.of(code).sum() % 10) == checksum;

        return result;
    }

    public static int checkLength(customer cus, int index){
        int len = cus.getBarCode(index).length();
        if (len == 13){
            return 0;
        }
        else if (len == 15 | len == 18){
            return 1;
        } else{
            return 2;
        }
    }

    public static int checkLength(String barCode){
        int len = barCode.length();
        if (len == 13){
            return 0;
        }
        else if (len == 15 | len == 18){
            return 1;
        } else{
            return 2;
        }
    }

    public static boolean checkBarCode(HashMap<String, Integer> database, String customerCode){
        for (Map.Entry<String, Integer> e : database.entrySet()){
            if (customerCode.contains(e.getKey())){
                return true;
            }
        }
    }

    public static int checkMoney(float payment, product item, String code){
        return (payment > item.getPrice(code) | payment < 0) ? 1 : 0;
    }

    public static int returnInt(char c){
        return Integer.parseInt(String.valueOf(c));
    }
}
