import java.util.ArrayList;

public class ShortestCommonSuperstring {
    static int dp[][];

    public static void main(String args[]) {
        ArrayList<String> A = new ArrayList<>();
        A.add("abcd");
        A.add("cdef");
        A.add("fgh");
        A.add("de");
        int result = solve(A);
    }

    public static int solve(ArrayList<String> A) {
        dp = new int[A.size() + 1][A.size() + 1];
        int result = 0;
        for (int i = 0; i < A.size(); i++) for (int j = 0; j < A.size(); j++) dp[i][j] = -1;

        String make = "";
        System.out.println(calculate("abcd", 0, "cdef", 0, make));
        System.out.println(make);
        return result;
    }

    static int calculate(String A, int index1, String B, int index2, String make) {

        if (index1 >= A.length() && index2 >= B.length()) return 0;
        if (index1 >= A.length())
            return Math.abs(B.length() - index2);
        if (index2 >= B.length())
            return Math.abs(A.length() - index1);

        if (dp[index1][index2]  != -1) return dp[index1][index2];

        int value = Integer.MAX_VALUE;
        if (A.charAt(index1) == B.charAt(index2))
            value = calculate(A, index1 + 1, B, index2 + 1, make + B.charAt(index1));

        value = Math.min(value, (1 + calculate(A, index1 + 1, B, index2 + 1, make + B.charAt(index1))));
        value = Math.min(value, (1 + calculate(A, index1 + 1, B, index2, make + A.charAt(index1))));
        value = Math.min(value, (1 + calculate(A, index1, B, index2 + 1, make + A.charAt(index2))));

        return dp[index1][index2] = value;
    }
}
