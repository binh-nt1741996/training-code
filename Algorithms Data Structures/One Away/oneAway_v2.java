import java.util.Scanner;
import java.lang.Math;

public class oneAway_v2 {

    static boolean oneEditAway(String str1, String str2){
        if (Math.abs(str1.length() - str2.length()) > 1){
            return false;
        }
        String s1 = str1.length() > str2.length() ? str2 : str1;
        String s2 = str1.length() > str2.length() ? str1 : str2;

        int index1 = 0, index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()){
            if (s1.charAt(index1) != s2.charAt(index2)){
                if (s1.length() == s2.length()){
                    index1++;
                }
                if (index1 != index2){
                    return false;
                }
            }
            else{
                index1++;
            }
            index2++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two strings: ");
        String[] strArr = in.nextLine().split(" ", -1);
        System.out.println(oneEditAway(strArr[0], strArr[1]));
    }
}
