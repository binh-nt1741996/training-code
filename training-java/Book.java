import java.util.ArrayList;
import java.util.Arrays;

public class Book{

    public static int swap(int a, int b){
        return a;
    }
    public static void main(String[] args) {
        int date = 17;
        int month = 4;
        date = swap(month, month = date);
        System.out.println(String.format("Today is day %d", date));
    }
}
