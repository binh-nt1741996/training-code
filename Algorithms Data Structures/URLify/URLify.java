import java.util.Scanner;

/**
 * URLify
 */
public class URLify {
    static String urlify(String str){
        String[] strArr = str.split(" ");
        return(String.join("%20", strArr));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string for urlify: ");
        String str = in.nextLine();
        System.out.println(urlify(str));
    }
}