import java.util.ArrayList;

/**
 * magic
 */
public class magic {
    public static int index(int[] arr){
        ArrayList<Integer> memo = new ArrayList<Integer>();
        if (arr.length <= 0)
            return(-1);
        else{
            return index(arr, 0, arr.length - 1, memo);
        }
    }

    public static int index(int[] arr, int start, int end, ArrayList<Integer> memo){
        if (end < start)
            return(-1);
        int mid = (start + end) / 2;
        if(arr[mid] == mid)
            return(mid);
        else if(arr[mid] < mid){
            System.out.println(mid);
            if (memo.contains(arr[mid])){
                return index(arr, start++, end, memo);
            }
            memo.add(arr[mid]);
            return index(arr, mid + 1, end, memo);
        }
        else{
            System.out.println(mid);
            if (memo.contains(arr[mid])){
                return index(arr, start, end--, memo);
            }
            memo.add(arr[mid]);
            return index(arr, start, mid - 1, memo);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{-40, 1, 2, 2, 2, 3, 5, 6, 9, 12, 13};
        System.out.println(index(input));
    }
}