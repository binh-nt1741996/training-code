/**
 * bucket_sort
 */
public class bucket_sort {

    public void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1
            while (j >=0 & arr[j] > key){
                arr[j + 1] = arr[j];
                j-=1;
            }
            arr[j + 1] = key;
        }
    }


}