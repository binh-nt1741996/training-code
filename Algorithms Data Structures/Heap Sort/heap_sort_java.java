/**
 * heap_sort_java
 */
import java.util.Scanner;

public class heap_sort_java {

    public static int swap(int a, int b){
        return a;
    }
    void heapify(int[] arr, int n, int i){
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if ((left < n) & (arr[left] > arr[i])){
            largest = left;
        }
        if ((right < n) & (arr[right] > arr[largest])){
            largest = right;
        }
        if (largest != i){
            arr[i] = swap(arr[largest], arr[largest] = arr[i]);
            heapify(arr, n, largest);           
        }
    }

    void build_max_heap(int[] arr){
        int len = arr.length;
        //build max heap
        for (int i = (int)(len/2) - 1; i >= 0; i--){
            heapify(arr, len, i);
        }
        //sort by extracting an element from root to the end
        for (int i = len - 1; i >= 1; i--){
            arr[i] = swap(arr[0], arr[0] = arr[i]);
            heapify(arr, i, 0);
        }
    }
    
    static void printArray(int[] arr){
        for (int i : arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
    }
}