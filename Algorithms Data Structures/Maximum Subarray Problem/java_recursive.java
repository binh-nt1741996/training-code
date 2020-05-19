import java.util.*;
import java.io.*;
import java.lang.*;


public class java_recursive {
    /*static int[] maxCrossingsum(int[] arr, int low, int mid, int high){
        int left_sum, right_sum;
        left_sum = right_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i > low - 1; i--){
            sum = sum + arr[i];
            if (sum > left_sum){
                left_sum = sum;
            }
        }
        sum = 0;
        for (int j = mid+1; j < high; j++ ){
            sum = sum + arr[j];
            if (sum > right_sum){
                right_sum = sum;
            }
        }
        return left_sum + right_sum;
    }

    static int[] findMaxSubarray(int[] arr, int low, int high){
        if (low == high){
            return arr[low];
        }
        else {
            mid = Math.floor((low + high)/2);
            left_sum = findMaxSubarray(arr, low, mid);
            right_sum = findMaxSubarray(arr, mid+1, high);
            cross_sum = maxCrossingsum(arr, low, mid, high);
            return 
        }
    }*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("You have entered string " + s);
    }   
}
