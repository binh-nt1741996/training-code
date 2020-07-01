import java.util.Scanner;

/**
 * uniqueStr
 */
public class uniqueStr {
    //Using bitvector
    static boolean isUniqueStr(String str){
        int checker = 0;
        for (int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0){
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
    //Using normal array
    /*boolean isUniqueStr(String str){
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if (char_set[val]){
                return false;
            }
        }
        return true;
    }
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(isUniqueStr(str));
    }
}