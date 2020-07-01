/**
 * palindromePermu
 */
import java.util.*;
public class palindromePermu {
    static boolean check(String str){
        int[] letters = new int[128];
        for (int i = 0; i < str.length(); i++){
            int val = (int)str.charAt(i);
            letters[val]++;
        }
        System.out.println(Arrays.toString(letters));
        int counter = 0;
        for (int c : letters){
            if (c == 1){
                counter++;
                if (counter == 2){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(check(str));
    }
}