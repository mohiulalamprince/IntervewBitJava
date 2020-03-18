import java.util.ArrayList;
import java.util.Collections;

public class Stairs {
    public static void main(String args[]) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int A) {
        ArrayList<Integer> table = new ArrayList<>(Collections.nCopies(40, 0));
        table.set(0, 1);
        table.set(1, 1);

        for (int i = 2; i < 38; i++) {
            int x = table.get(i - 1);
            int y = table.get(i - 2);
            table.set(i, x + y);
        }
        return table.get(A);
    }
}
