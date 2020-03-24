import java.util.ArrayList;
import java.util.Arrays;

public class JumpGameArray {
    public static void main(String args[]) {
        System.out.println(canJump(new ArrayList<>(Arrays.asList(1, 1))));
    }

    public static int canJump(ArrayList<Integer> A) {
        if (A.size() == 1 && A.get(0) == 0) return 1;
        if (A.size() == 1 && A.get(0) != 0) return 0;

        int result = 0;

        int currentIndex = A.size() - 2;
        int target = A.size() - 1;
        while (true) {
            if ((target - currentIndex) <= A.get(currentIndex)) {
                target = currentIndex;
                if (currentIndex == 0) {
                    result = 1;
                    break;
                }
                currentIndex --;
            } else {
                currentIndex --;
                if (currentIndex < 0)
                    break;
            }
        }
        return result;
    }
}
