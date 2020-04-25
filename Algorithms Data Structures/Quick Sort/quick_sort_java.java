/**
 * quick_sort_java
 */
public class quick_sort_java {
    public static int swap(int first, int second){
        return first;
    }
    public static int partition(int[] arr, int left, int right){
        int i = left - 1;
        int pivot = arr[right - 1];
        for (int j = left; j < right - 1; j++){
            if (arr[j] <= arr[pivot]){
                i++;
                arr[j] = swap(arr[i], arr[i] = arr[j]);
            }
        }
        i++;
        arr[i] = swap(arr[pivot], arr[pivot] = arr[i]);
        return i;
    }

    public void quicksort(int[] arr, int left, int right){
        if (left < right){
            int p = partition(arr, left, right);
            quicksort(arr, left, p - 1);
            quicksort(arr, p + 1, right);
        }

    }
}