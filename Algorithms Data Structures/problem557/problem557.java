/**
 * problem557
 */
import java.util.*;

public class problem557 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of n and x: ");
        String str = in.nextLine();
        String[] strInt = str.split(" ");

        List<Integer> listInt = new ArrayList<Integer>();
        for (String number : strInt){
            listInt.add(Integer.parseInt(number));
        }
        int counter = 0;
        int n = listInt.get(0);
        int x = listInt.get(1);
        for (int i = 1; i <= listInt.get(0); i++){
            if ((x % i == 0) & (x/i <= n)){
                counter+=1;
            }
        }   
        System.out.println(counter);
    }
}
