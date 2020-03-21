
public class WaysToDecode {
    public static void main(String args[]) {
        System.out.println(numDecodings("0"));
    }

    public static int numDecodings(String str) {
        if (str.length() <= 1 && str.charAt(0) != '0') return 1;
        if (str.length() <= 1 || str.charAt(0) == 0) return 0;

        int N = str.length();
        int dp[] = new int[N + 1];

        dp[0] = 1;
        if (str.charAt(1) == '0') dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int x = Integer.parseInt(str.substring(i-1, i));
            int y = Integer.parseInt(str.substring(i - 2, i));

            if (x >= 1 && x <= 9) {
                dp[i] += dp[i-1];
            }
            if (y >= 10 && y <= 26)
                dp[i] += dp[i-2];
        }
        return dp[N];
    }
}
