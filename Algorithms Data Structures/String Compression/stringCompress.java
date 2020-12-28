import java.util.Scanner;

public class stringCompress {
    static String compress(String str){
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++){
            countConsecutive++;
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
                compressedString.append(str.charAt(i));
                compressedString.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length()? compressedString.toString() : str;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(compress(str));
    }    
}
