import java.util.*;

public class Equal {
    public static void main(String args[]) {
        ArrayList<Integer> result = equal(new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1)));
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> equal(ArrayList<Integer> A) {
        int inf = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>((Arrays.asList(inf, inf, inf, inf)));
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int sum = A.get(i) + A.get(j);
                if (map.containsKey(sum)) {
                    ArrayList<Integer> indexes = new ArrayList<>(map.get(sum));
                    indexes.add(i);
                    indexes.add(j);

                    if (indexes.get(0) < indexes.get(2)
                            && indexes.get(1) != indexes.get(3)
                            && indexes.get(1) != indexes.get(2)) {
                        if (indexes.get(0) < result.get(0)
                                    || (indexes.get(0) == result.get(0) && indexes.get(1) < result.get(1))) {
                            result = new ArrayList<>(indexes);
                        } else if (indexes.get(0) == result.get(0) && indexes.get(1) == result.get(1) && indexes.get(2) < result.get(2)) {
                            result = new ArrayList<>(indexes);
                        } else if (indexes.get(0) == result.get(0) && indexes.get(1) == result.get(1) && indexes.get(2) == result.get(2) && indexes.get(3) < indexes.get(3)) {
                            result = new ArrayList<>(indexes);
                        }
                    }
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Integer>(Arrays.asList(i, j)));
                }
            }
        }
        if (result.size() > 0 && result.get(0) != inf) return result;
        return new ArrayList<>();
    }
}
