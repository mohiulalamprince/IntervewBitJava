import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyAndSellStockII {
    static int max_profit = Integer.MIN_VALUE;
    static int dp[];

    public static void main(String args[]) {
        System.out.println(maxProfit(new ArrayList<>(Arrays.asList(5, 2, 10))));
    }

    public static int maxProfit(final List<Integer> A) {
        dp = new int[A.size() + 10];
        max_profit = Integer.MIN_VALUE;
        Arrays.fill(dp, -1);

        dfs(A, 0, 0, true);
        
        return max_profit;
    }

    public static void dfs(List<Integer> A, int index, int sum, boolean is_buy) {
        if (sum > max_profit) max_profit = sum;
        if (dp[index] != -1) return ;
        if (index >= A.size()) {
            return ;
        }

        if (is_buy) {
            dfs(A, index + 1, sum - A.get(index), !is_buy);
        } else {
            dfs(A, index + 1, sum + A.get(index), !is_buy);
        }
        dfs(A, index + 1, sum, is_buy);
    }
}
