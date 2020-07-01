/**
 * oneAway
 */
import java.lang.Math;
import java.util.*;

public class oneAway {
    static boolean replace(String str1, String str2){
        int counter = 0;
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                counter++;
            }
            if (counter == 2){
                return false;
            }
        }
        return true;
    }

    static boolean insert(String str1, String str2){
        int counter = 0;
        for (int i = 0; i < str1.length(); i++){
            if (counter == 1){
                if (str2.charAt(i - 1) != str1.charAt(i)){
                    return false;
                }
            }
            else {
                if (str2.charAt(i) != str1.charAt(i)){
                    counter++;
                }
            }
        }
        return true;
    }
    static boolean check(String str1, String str2){
        if (str1.length() == str2.length()){
            return replace(str1, str2);
        }
        else if (str1.length() == str2.length() + 1){
            return insert(str1, str2);
        }
        else{
            return insert(str2, str1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two strings: ");
        String[] strArr = in.nextLine().split(" ", -1);
        System.out.println(check(strArr[0], strArr[1]));
    }
}