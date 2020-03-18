import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreastingSubsequence {
    public static void main(String args[]) {
        System.out.println(lis( new ArrayList<>(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15))));
    }

    public static int lis(final List<Integer> A) {
        int result = 0;
        ArrayList<Integer> lis = new ArrayList<>(Collections.nCopies(A.size(), 1));

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && lis.get(i) < lis.get(j) + 1)
                    lis.set(i, lis.get(j) + 1);
            }
        }

        result = -1000000000;
        for (int i = 0; i < lis.size(); i++) {
            if (result < lis.get(i)) {
                result = lis.get(i);
            }
        }

        return result;
    }
}
