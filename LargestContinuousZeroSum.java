import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousZeroSum {
    public static void main(String args[]) {
        ArrayList<Integer> result = lszero(new ArrayList<>(Arrays.asList(5, 0, 3, -2, -1)));
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> lszero(ArrayList<Integer> a) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int currentStart = 0;
        int currentEnd = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i);
            if (map.containsKey(sum)) {
                currentStart = map.get(sum);
                currentEnd = i;

                if (end - start + 1 < currentEnd - currentStart + 1) {
                    start = currentStart;
                    end = currentEnd;
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start + 1; i <= end; i++) {
            result.add(a.get(i));
        }
        return result;
    }
}
