import java.util.*;

class countSort{
	public static int[] sorting(int[] arr, int k){
		//create array to hold frequency of element in arr
		int[] subarr = new int[k + 1];
		
		//count frequency of element in arr
		//here, index of subarr = element in arr
		for (int i = 0; i < arr.length; i++){
			subarr[arr[i]] = subarr[arr[i]] + 1;
		}
		
		//count no of elements less than or equal to
		//each of element in arr
		for (int j = 1; j < k+1; j++){
			subarr[j] = subarr[j] + subarr[j - 1];
		}
		
		//create array to hold sorted elements
		int[] sortedArr = new int[arr.length];
		
		//each element in subarr shows the number of elments
		//less than or equal to the "index" in subarr
		for (int l = arr.length - 1; l >= 0; l--){
			sortedArr[subarr[arr[l]] - 1] = arr[l];
			subarr[arr[l]] = subarr[arr[l]] - 1;
			
		}
		return(sortedArr);
	}				
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter length for input arrays: ");
		int len = in.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++){
			System.out.print("Enter element no " + (i+1) + ": ");
			arr[i] = in.nextInt();
		}
		System.out.println("\n Before sorting..");
		for (int i = 0; i < len; i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n After sorting..");
		int[] sortedArr = countSort.sorting(arr, 9);
		for (int i = 0; i < len; i++){
			System.out.print(sortedArr[i] + "\t");
		}

	}
}
