import java.util.*;

/**
 * stringCompression
 */
public class stringCompression {
    static String stringCompress(String str){
        int[] letters = new int[128];
        for (int i = 0; i < str.length(); i++){
            int val = (int)str.charAt(i);
            letters[val]++;
        }
        char temp = Character.MIN_VALUE;
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            int val = (int)str.charAt(i);
            if (temp != str.charAt(i)){
                temp = str.charAt(i);
                finalStr.append(str.charAt(i)).append(letters[val]);
                letters[val]
            }
        }
        String result = finalStr.toString().length() < str.length()? finalStr.toString() : str;
        return result;
        
    }
    public static void main(String[] args) {
        System.out.println(stringCompress("abbbccabb"));
    }
}