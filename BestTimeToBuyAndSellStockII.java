import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(final int[] A) {

        int sp, cp;
        int profit =0;
        for(int i = 0; i< A.length-1; i++){
            cp = A[i];
            sp = A[i+1];

            if(sp > cp){
                profit += sp - cp;
            }
        }

        return profit;
    }
}
