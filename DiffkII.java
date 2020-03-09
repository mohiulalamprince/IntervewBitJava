import java.util.*;

public class DiffkII {
    public static void main(String args[]) {
        System.out.println(diffPossible(new ArrayList<>(Arrays.asList(1, 3, 5)), 2));
    }

    public static int diffPossible(final List<Integer> A, int B) {
        Map<Integer, Boolean> map = new HashMap<>();

        ArrayList<Integer> a = new ArrayList<>(A);
        Collections.sort(a, Collections.reverseOrder());
        for (int i = 0; i < a.size(); i++) {
            if (map.containsKey(a.get(i) + B) == true) {
                return 1;
            }
            if (!map.containsKey(a.get(i) + B)) {
                map.put(a.get(i), true);
            }
        }
        return 0;
    }
}
