import javafx.util.Pair;

import java.util.*;

public class FourSum {
    static class UniqueSet {
        int a;
        int b;
        int c;
        int d;

        UniqueSet(int x, int y, int z, int p) {
            a = x;
            b = y;
            c = z;
            d = p;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c, d);
        }
    }
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> result = fourSum(new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2)), 0);

        Map<UniqueSet, Boolean> uniqueSet = new HashMap<>();
        result.forEach(x -> {
            Collections.sort(x);
            uniqueSet.put(new UniqueSet(x.get(0), x.get(1), x.get(2), x.get(3)), true);
        });

        uniqueSet.forEach((k, v) -> {
                //System.out.println(k.a + " " + k.b + " " + k.c + " " + k.d);
            }
        );
    }
    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Pair<Integer, Integer> currentStart = new Pair<>(0, 0);
        Pair<Integer, Integer> currentEnd = new Pair<>(0, 0);
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();

        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int firstPairSum = A.get(i) + A.get(j);
                int remain = B - firstPairSum;
                if (map.containsKey(remain)) {
                    currentStart = map.get(remain);
                    currentEnd = new Pair<>(A.get(i), A.get(j));

                    result.add(new ArrayList<>(Arrays.asList(currentStart.getKey(),
                            currentStart.getValue(),
                            currentEnd.getKey(),
                            currentEnd.getValue())));
                }
                if (!map.containsKey(firstPairSum)) {
                    map.put(firstPairSum, new Pair<>(A.get(i), A.get(j)));
                }
            }
        }
        return result;
    }
}
