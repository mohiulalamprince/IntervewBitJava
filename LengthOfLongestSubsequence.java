import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LengthOfLongestSubsequence {
    public static void main(String args[]) {
        System.out.println(longestSubsequenceLength(Arrays.asList(1, 2, 3, 4, 5)));
    }

    public static int longestSubsequenceLength(final List<Integer> input) {
        if (input.size() <= 2) return input.size();

        ArrayList<Integer> ordered = new ArrayList<>();
        ArrayList<Integer> reverse = new ArrayList<>();

        ArrayList<Integer> A = new ArrayList<>(input);

        ordered = lis(A);

        Collections.reverse(A);
        reverse = lis(A);

        Collections.reverse(reverse);

        int max = -1000000000;
        for (int i = 0; i < A.size(); i++) {
            if (ordered.get(i) + reverse.get(i) - 1> max)
                max = ordered.get(i) + reverse.get(i) - 1;
        }

        return max == -1000000000 ? 1 : max;
    }

    public static ArrayList<Integer> lis(List<Integer> A) {
        ArrayList<Integer> lis = new ArrayList<>(Collections.nCopies(A.size(), 0));

        for (int i = 0; i < A.size(); i++) lis.set(i, 1);

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && lis.get(i) < lis.get(j) + 1) {
                    lis.set(i, lis.get(j) + 1);
                }
            }
        }

        return lis;
    }
}
