/**
 * quick_sort_java
 */
import java.util.Scanner;

class quick_sort_java {
    public static int swap(int first, int second){
        return first;
    }

    public int partition(int[] arr, int left, int right){
        int key = arr[right];
        int i = left - 1;
        for (int j = left; j <= right - 1; j++){
            if (arr[j] < key){
                i++;
                arr[j] = swap(arr[i], arr[i] = arr[j]);
            }
        }
        i++;
        arr[i] = swap(arr[right], arr[right] = arr[i]);
        return i;
    }

    public void quickSort(int[] arr, int left, int right){
        if (left < right){
            int q = partition(arr, left, right);
            quickSort(arr, left, q - 1);
            quickSort(arr, q + 1, right);
        }
    }
    
    """public void quickSort(int[] arr, int left, int right){
        if (left < right){
            int mid = (int) (left + right)/2;
            
        }
    }"""
    public static void printArray(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        quick_sort_java qs = new quick_sort_java();
        //Getting input for length of array
        System.out.print("Enter length of array: ");
        int len = in.nextInt();
        //Declare the array holding input integers
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            System.out.print("Enter element no " + (i + 1) + ": ");
            arr[i] = in.nextInt();
        }
        //Before sorting
        System.out.println("Before Sorting");
        printArray(arr);
        //Sorting
        qs.quickSort(arr, 0, len - 1);
        //After sorting
        System.out.println("After Sorting");
        printArray(arr);
    }
}