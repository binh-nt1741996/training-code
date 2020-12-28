import java.util.Arrays;
import java.util.Scanner;

/**
 * permutationString
 */
public class permutationString {

    static boolean checker(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }
        int[] letters = new int[128];
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        for (int i = 0; i < c1.length; i++){
            int val = c1[i];
            letters[i]++;
        }

        for (int j = 0; j < c2.length; j++){
            val = c2[i];
            letters[val]--;
        }

        for (int i = 0; i < letters.length; i++){
            if (letters[i] != 0){
                return false;
            }
        }
        return true;
    }
    /*static boolean checker(String str1, String str2){
        int[] letters = new int[128];
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        if (str1.length() != str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++){
            int val = (int)str1.charAt(i);
            letters[val]++;
        }
        for (int i = 0; i < str1.length(); i++){
            int c = (int)str2.charAt(i);
            letters[c]--;
            if (letters[c] < 0){
                return false;
            }
        }
        return true;
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter two strings for checking: ");
        String initialStr = in.nextLine();
        String[] strArr = initialStr.split(" ");
        System.out.println(checker(strArr[0], strArr[1]));
    }
}