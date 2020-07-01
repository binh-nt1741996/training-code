/**
 * problem
 */
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class problem {
	static int[] merge(int[] arr){
		int pivot = 0;
		for (int k = 0; k < arr.length; k++){
			if (arr[k] >= 0){
				pivot = k;
				break;
			}
			pivot = k;
		}
		System.out.println(pivot);
		int[] temp = new int[arr.length];
		int neg = pivot - 1;
		int pos = pivot;
		int i = 0;
		while (neg >= 0 & pos < arr.length){
			if (Math.pow(arr[neg], 2) < Math.pow(arr[pos], 2)){
				temp[i] = (int)Math.pow(arr[neg], 2);
				neg--;
			}
			else{
				temp[i] = (int)Math.pow(arr[pos], 2);
				pos++;
			}
			i++;
		}
		while (neg >= 0){
			temp[i++] = (int)Math.pow(arr[neg], 2);
			neg--;
		}
		while (pos < arr.length){
			temp[i++] = (int)Math.pow(arr[pos], 2);
			pos++;
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a list of integers: ");
		String[] strArr = in.nextLine().split(" ", -1);
		int[] arr = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++){
			arr[i] = Integer.parseInt(strArr[i]);
		}
		System.out.println(Arrays.toString(merge(arr)));
	}
}