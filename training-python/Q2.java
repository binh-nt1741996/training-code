/**
 * Q2
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;  // Import this class to handle errors


public class Q2 {

    public static void maxProfit(int[] arr){
        int min_price = arr[0];
        int max_profit, sell, buy;
        max_profit = sell = buy = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min_price){
                buy = i;
                min_price = arr[i];
            }
            else if (arr[i] - min_price > max_profit){
                sell = i;
                max_profit = arr[i] - min_price;
            }
        }
        if (sell == 0){
            System.out.println("Can't do the transaction");
        }
        else{
            System.out.println(String.format("buy %d, sell %d", arr[buy], arr[sell]));
        }
    }

    public static void main(String[] args) {
        try{
            File file = new File("file.txt"); 
            Scanner in = new Scanner(file);
            String[] strArr = in.nextLine().split(" ");
            int[] arr = new int[strArr.length];
            for (int i = 0; i < strArr.length; i++){
                arr[i] = Integer.parseInt(strArr[i]);
            }
            in.close();
            maxProfit(arr);
        }
        catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        };
    }
}