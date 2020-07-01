//package com.selfCheckOut;

import java.util.ArrayList;

public class order {
    private ArrayList<product> products = new ArrayList<product>();
    private ArrayList<customer> customers = new ArrayList<customer>();

    public void getProduct(){
        for (product item : products){
            System.out.println(item.getCode());
        }
    }

    public void getCustomer(){
        for (customer cus : customers){
            ArrayList<String> barCode = cus.getBarCode();
            output out = new output();
            out.analyzeBarCode(barCode);
        }
    }

    public void getOrder(String[] orderInput){
        int num = Integer.parseInt(orderInput[0]);
        products = new ArrayList<product>(num);
        int i = 1;
        while (!orderInput[i].contains("start")){
            product item = new product();
            analyzeProductInfo(item, orderInput[i]);
            products.add(item);
            i++;
        }

        for (int counter = i; counter < orderInput.length; counter += (num + 2)){
            customer cus = new customer();
            analyzeCustomerInfo(cus, orderInput[counter], "pointCard");
            for (int j = 0; j < num; j++){
                analyzeCustomerInfo(cus, orderInput[counter + j + 1], "receiptInfo");
            }
            customers.add(cus);
        }

    }

    public void analyzeProductInfo(product item, String productInfo){
        
        String[] productDetail = productInfo.split(" ", -1);
        if (productDetail.length == 2) {
            item.setType("Normal Product");
        } else{
            item.setType("Sold by weight Product");
        }

        if (item.getType().equals("Normal Product")){
            item.setCode(productDetail[0]);
            item.setPrice(Integer.parseInt(productDetail[1]));
        } else{
            item.setCode(productDetail[0]);
        }
    }

    public void analyzeCustomerInfo(customer cus, String customerInfo, String type){
        
        if (type.equals("pointCard")){
            String[] customerDetail = customerInfo.split(" ", -1);
            if (customerDetail.length == 2){
                cus.setID(customerDetail[1]);
            }
        } else{
            cus.setBarCode(customerInfo);
        }
    }
}
