import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {
    public static int binary_search(int lo, int hi, int value, ArrayList<Integer> A) {
        if (lo >= hi) return lo;
        int mid = (lo + hi) / 2;
        if (A.get(mid) >= value) return binary_search(0, mid, value, A);
        else if (A.get(mid) < value) return binary_search(mid + 1, hi, value, A);
        else return mid + 1;
    }

    public static int search(int lo, int hi, ArrayList<ArrayList<Integer>> A) {
        int result = 0;

        while (lo <= hi) {
            result = 0;
            int mid = (int)(((long)lo) + ((long)hi)) / 2;
            for (int i = 0; i < A.size(); i++) {
                result += binary_search(0, A.get(0).size(), mid, A.get(i));
            }
            int N = A.size() * A.get(0).size();
            int rightSide = N - result;
            int leftSide = result;
            if ((N/2) >= leftSide) {
                lo = mid + 1;
                hi = hi;
            } else if ((N/2) < leftSide) {
                lo = lo;
                hi = mid-1;
            }
        }
        return hi;
    }

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int result = 0;
        int int_max = Integer.MAX_VALUE;
        result = search(0, int_max, A);
        return result;
    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList(Arrays.asList(1, 3, 5)));
        A.add(new ArrayList(Arrays.asList(2, 6, 9)));
        A.add(new ArrayList(Arrays.asList(3, 6, 9)));

       int res1 = findMedian(A);

        A.clear();
        A.add(new ArrayList<>(Arrays.asList(5, 13, 100)));
        int res2 = findMedian(A);
        System.out.println(res1 + " " + res2);
   }
}
