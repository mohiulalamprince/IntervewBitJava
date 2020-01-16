import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {
    public static int left_binary_search(int lo, int hi, int value, List<Integer> A) {
        if (lo >= hi) return lo;
        int mid = (lo + hi) / 2;
        if (A.get(mid) < value) {
            return left_binary_search(mid + 1, hi, value, A);
        } else if (A.get(mid) == value) {
            return left_binary_search(lo, mid, value, A);
        }
        else return -1;
    }

    public static int right_binary_search(int lo, int hi, int value, List<Integer> A) {
        if (lo >= hi) return hi-1;
        int mid = (lo + hi) / 2;
        if (A.get(mid) > value) {
            return right_binary_search(lo, mid, value, A);
        } else if (A.get(mid) == value) {
            return right_binary_search(mid+1, hi, value, A);
        }
        else return -1;
    }

    public static int binary_search(int lo, int hi, int value, List<Integer> A) {
        if (lo >= hi) return -1;
        int mid = (lo + hi) / 2;
        if (A.get(mid) > value) return binary_search(lo, mid, value, A);
        else if (A.get(mid) < value) return binary_search(mid + 1, hi, value, A);
        else return mid;
    }

    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int output = binary_search(0, A.size(), B, A);
        if (output == -1) return new ArrayList<Integer>(Arrays.asList(-1, -1));

        int start = left_binary_search(0, output, B, A);
        int end = right_binary_search(output, A.size(), B, A);
        return new ArrayList<Integer>(Arrays.asList(start, end));
    }

    public static void main(String args[]) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 7, 7, 7, 7, 7, 8, 8, 8, 8));
        int B = 7;
        List<Integer> C = searchRange(A, B);
        C.forEach(x -> System.out.println(x));
    }
}
