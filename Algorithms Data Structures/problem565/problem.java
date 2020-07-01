/**
 * problem
 */
/*
This problem was asked by Pinterest.

Given an integer list where each number 
represents the number of hops you can make, 
determine whether you can reach to the last 
index starting at index 0.
*/
import java.util.*;

public class problem {

    static boolean checkHops(int[] arr, int i){
        int curr = i;
        if (i >= arr.length - 1){
            return true;
        }
        if (arr[i] == 0){
            return false;
        }
        return checkHops(arr, curr + arr[i]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArr = in.nextLine().split(" ", -1);
        int[] arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        System.out.println(checkHops(arr, 0));
    }
}