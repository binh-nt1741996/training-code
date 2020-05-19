/**
 * practice
 */
public class practice {
    public static int swap(int first, int second){
        return first;
    }
    public void heapify(int[] arr, int n, int i){
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;
        if ((left < n) & (arr[left] > arr[i])){
            largest = left;
        }
        if ((right < n) & (arr[right] > arr[largest])){
            largest = right;
        }
        if (largest != i){
            arr[largest] = swap(arr[i], arr[i] = arr[largest]);
            heapify(arr, n, largest);
        }
    }

    public void max_heap(int[] arr){
        int len = arr.length;
        
    }
    public static void main(String[] args) {
        
    }
}