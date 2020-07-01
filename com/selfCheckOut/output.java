//package com.selfCheckOut;

import java.util.ArrayList;

public class output {

    public void analyzeBarCode(ArrayList<String> barCode){
        
        HashMap<String, Integer> database = item.getDataBase();
        for (String code : barCode){
            product item = new product();
            if (code.charAt(0) == '0' & code.charAt(1) == '2'){
                item.setType("Sold by weight Product");
            } else{
                item.setType("Normal Product");
            }
            ArrayList<Integer> error = new ArrayList<Integer>();
            error.add(!validate.checkBarCode(database, code)? 2 : 1);
            error.add(!validate.checkCheckSum(code)? 2 : 0);
            error.add(validate.checkLength(code));
            float payment = 0;
            if (!error.contains(2)) {
                switch (code.length()) {
                    case 15: {
                        if (item.getType() == "Normal Product"){
                            code = code.substring(0, 12);
                        }
                        else{
                            code = code.substring(2, 7);
                        }
                        System.out.println(code);
                        int percent = validate.returnInt(code.charAt(12)) * 10 + validate.returnInt(code.charAt(13));
                        payment = item.getPrice(code) * (float) percent / 100;
                        error.add(validate.checkMoney(payment, item, code));
                        break;
                    }
                    case 18: {
                        if (item.getType() == "Normal Product"){
                            code = code.substring(0, 12);
                        }
                        else{
                            code = code.substring(2, 7);
                        }
                        int saleOff = Integer.parseInt(code.substring(12, 17));
                        payment = item.getPrice(code) - saleOff;
                        error.add(validate.checkMoney(payment, item, code));
                        //break;
                    }
                    case 13: {
                        code = code.substring(0, 12);
                        payment = item.getPrice(code);
                        //break;
                    }
                }
            }
        }
        if (!(error.contains(1) | error.contains(2))){
            System.out.println(payment);
        } else if (!error.contains(2)){
            System.out.println("Staff call: 1");
        } else if (!error.contains(1)){
            System.out.println("Staff call: 2");
        } else{
            System.out.println("Staff call: 1 2");
        }
    }
}
