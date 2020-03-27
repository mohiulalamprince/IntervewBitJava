import java.lang.reflect.Array;
import java.util.Arrays;

public class PalindromePartition2 {
    static int dp[];
    public static void main(String args[]) {
        System.out.println(minCut("aabbcc"));
    }

    public static int minCut(String A) {
        int result = 0;
        dp = new int[A.length() + 1];
        Arrays.fill(dp, -1);

        result = dfs(0, A) - 1;
        return result;
    }

    public static int dfs(int index, String A) {
        int split = Integer.MAX_VALUE;
        if (index >= A.length()) return 0;

        if (dp[index] != -1) return dp[index];

        for (int i = index; i < A.length(); i++) {
            if (isPalindrome(A, index, i)) {
                split = Math.min(split, 1 + dfs(i + 1, A));
            }
        }
        return dp[index] = split;
    }

    public static boolean isPalindrome(String A, int start, int end) {
        while (start < end && A.charAt(start) == A.charAt(end)) {
            start ++;
            end--;
        }
        return start >= end;
    }
}
