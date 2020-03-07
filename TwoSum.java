import java.util.*;

public class TwoSum {
    public static void main(String args[]) {
        ArrayList<Integer> result = twoSum(new ArrayList<>(Arrays.asList(1, 11, 2, 2, 15, 3, 7)), 9);
        result.forEach(x -> System.out.println(x));
    }
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        int inf = -2000000000;
        int currentStart = 0;
        int currentEnd = 0;
        int start = inf;
        int end = inf;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            int remain = B - A.get(i);
            if (map.containsKey(remain)) {
                currentStart = map.get(remain);
                currentEnd = i;

                if (currentEnd < end || end == inf) {
                    end = currentEnd;
                    if (currentStart < start || start == inf) {
                        start = currentStart;
                    }
                }
                if (currentEnd == end) {
                    if (currentStart < start) {
                        start = currentStart;
                    }
                }
                map.put(A.get(i), i);
            }
            if (!map.containsKey(A.get(i))) {
                map.put(A.get(i), i);
            }
        }
        if (start == inf || end == inf) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(start + 1, end + 1));
    }
}
