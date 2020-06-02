import java.util.*;
import java.io.*;

class radixSort{
	static int getMax(int[] arr){
		int n = arr.length;
		int max = -10000;
		for (int i = 0; i < n; i++){
			if (arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}

	static void countingSort(int[] arr, int k, int exp){
		int n = arr.length;
		int[] count = new int[10];
		int[] output = new int[n];
		Arrays.fill(count, 0);
		for (int i = 0; i < n; i++){
			count[(arr[i]/exp)%10] += 1;
		}
		for (int i = 1; i < 10; i++){
			count[i] = count[i] + count[i-1];
		}
		for (int i = n-1; i >= 0; i--){
			output[count[(arr[i]/exp)%10] - 1] = arr[i];
			count[(arr[i]/exp)%10] -= 1;
		}
		for (int i = 0; i < n; i++){
			arr[i] = output[i];
		}
	}
	static void print(int[] arr){
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	static void radixSort(int[] arr){
		int k = getMax(arr);
		for (int exp = 1; k/exp > 0; exp*=10){
			countingSort(arr, k, exp);
		}
	}
	public static void main(String[] args){
	        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
		radixSort(arr);
		for (int i = 0; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}

