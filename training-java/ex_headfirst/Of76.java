/**
 * Of76
 */
import java.util.Date;

public class Of76 {
    int i;
    Integer j;
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(String.format("Today is %tA/%<tB/%<td, and the time is %<tr", today));
    }
}