import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class EditDistance {
    static int dp[][];

    public static void main(String args[]) {
        System.out.println(minDistance("aabbabbabababbababaa", "abababb"));
    }

    public static int minDistance(String A, String B) {
        dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return calculate(A, 0, B, 0);
    }

    public static int calculate(String A, int index1, String B, int index2) {

        if (index1 >= A.length() && index2 >= B.length()) return 0;
        if (index1 >= A.length())
            return Math.abs(B.length() - index2);
        if (index2 >= B.length())
            return Math.abs(A.length() - index1);

        if (dp[index1][index2]  != -1) return dp[index1][index2];

        int value = Integer.MAX_VALUE;
        if (A.charAt(index1) == B.charAt(index2))
            value = calculate(A, index1 + 1, B, index2 + 1);

        value = Math.min(value, (1 + calculate(A, index1 + 1, B, index2 + 1)));
        value = Math.min(value, (1 + calculate(A, index1 + 1, B, index2)));
        value = Math.min(value, (1 + calculate(A, index1, B, index2 + 1)));

        return dp[index1][index2] = value;
    }
}
