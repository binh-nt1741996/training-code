import java.util.Arrays;
import java.util.Scanner;

/**
 * tripleStep
 */
public class tripleStep {
    public static int triple(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return triple(n, memo);
    }
    
    //memoization
    public static int triple(int n, int[] memo){
        if (n < 0)
            return(0);
        else if (n == 0)
            return(1);
        else if (memo[n] == -1){
            memo[n] = triple(n - 1, memo) + triple(n - 2, memo)+ triple(n - 3, memo);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(triple(input)); 
    }
}