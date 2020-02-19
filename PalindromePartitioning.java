import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartitioning {
    private static ArrayList<ArrayList<String>> result = new ArrayList<>();
    private static int[][] dp = new int[100][100];

    public static void main(String args[]) {
        for (int i = 0; i < 100; i++) for (int j = 0; j < 100; j++) dp[i][j] = -1;
        ArrayList<ArrayList<String>> output = partition("efe");
        for (int i = 0; i < output.size(); i++) {
            for (int j = 0; j < output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (dp[start][end] != -1) return dp[start][end] == 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void memo(int index, ArrayList<String> temp, String A) {
        if (index >= A.length()) {
            result.add(new ArrayList<>(temp));
            return ;
        }

        for (int i = index; i < A.length(); i++) {
            if (isPalindrome(A, index, i)) {
                temp.add(A.substring(index, i + 1));
                memo(i + 1, temp, A);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        memo(0, new ArrayList<>(), a);
        return result;
    }
}
