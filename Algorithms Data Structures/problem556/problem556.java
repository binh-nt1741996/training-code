/**
 * problem556
 */
/*
Given an array of integers, 
write a function to determine whether the array 
could become non-decreasing by modifying 
at most 1 element.

For example, given the array [10, 5, 7], 
you should return true, since we can modify the 10 
into a 1 to make the array non-decreasing.
*/
import java.util.*;

public class problem556 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int counter = 0;
        System.out.print("Enter integer for determine: ");
        String strInput = in.nextLine();
        String[] strInt = strInput.split(" ", -1);
        List<Integer> lsInt = new ArrayList<Integer>();
        for (String str : strInt){
            lsInt.add(Integer.parseInt(str));
        }
        int max = lsInt.get(0);
        int temp = 0;
        int result = 1;
        for (int i = 1; i < lsInt.size(); i++){
            if (lsInt.get(i) > max){
                max = lsInt.get(i);
            }
            else{
                counter += 1;
            }
            if ((counter >= 2) & (lsInt.get(i) < temp)){
                System.out.println("False");
                result = 0;
                break;
            }
            temp = lsInt.get(i);
        }
        if (result == 1){
            System.out.println("True");
        }
    }
}