import java.util.ArrayList;
import java.util.Arrays;

public class MinJumpArray {
    public static void main(String args[]) {
        System.out.println(jump(new ArrayList<>(Arrays.asList(2, 2, 1, 6, 1, 3, 0, 0, 1, 6))));
        System.out.println(jump(new ArrayList<>(Arrays.asList(2, 3, 1, 1, 4))));
        System.out.println(jump(new ArrayList<>(Arrays.asList(0))));
    }

    public static int jump(ArrayList<Integer> A) {
        if (A.size() == 1 && A.get(0) == 0) return 0;
        if (A.size() == 1 && A.get(0) != 0) return 0;

        int frequency = 1;
        int lastRange = A.get(0);
        int maxRange = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (maxRange < i)
                return -1;
            if (i > lastRange) {
                frequency++;
                lastRange = maxRange;
                if (maxRange >= A.size()) break;
            }
            maxRange = Math.max(maxRange, i + A.get(i));
        }
        return frequency;
    }
}
