import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public static void main(String args[]) {
        ArrayList<Integer> result = dNums(new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        if ( B > A.size()) return new ArrayList<>();

        int startPos = 0;
        int endPos = B-1;

        for (int i = 0; i < B; i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }
        while (endPos < A.size() - 1) {
            result.add(map.size());
            if (map.containsKey(A.get(startPos))) {
                int counter = map.get(A.get(startPos));
                if (counter == 1) {
                    map.remove(A.get(startPos));
                } else {
                    map.put(A.get(startPos), counter - 1);
                }
            }
            startPos ++;
            endPos ++;
            if (map.containsKey(A.get(endPos))) {
                map.put(A.get(endPos), map.get(A.get(endPos)) + 1);
            } else {
                map.put(A.get(endPos), 1);
            }
        }
        if (map.size() > 0) result.add(map.size());
        return result;
    }
}
