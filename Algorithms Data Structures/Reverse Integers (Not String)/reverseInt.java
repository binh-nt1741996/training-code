import java.lang.Math;
import java.util.*;
/**
 * reverseInt
 */
public class reverseInt {
    static int reverse(int x){
        int len = (int)Math.log10(x) + 1;
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += (int)Math.pow(10, len - i - 1) * (x%10);
            x = (int)x / 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter integer for reversing: ");
        int x = in.nextInt();
        System.out.println("Integer after being reversed: " + reverse(x));
    }
}
