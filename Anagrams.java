import java.util.*;

public class Anagrams {

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> result = anagrams(new ArrayList<>(Arrays.asList("cat", "dog", "god", "tca")));
        result.forEach(x -> {
            System.out.println(x);
        });
    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            String sample = A.get(i);
            char[] chars = sample.toCharArray();
            Arrays.sort(chars);
            sample = new String(chars);
            if (map.containsKey(sample)) {
                ArrayList<Integer> indexs = map.get(sample);
                indexs.add(i + 1);
                map.put(sample, indexs);
            }
            if (!map.containsKey(sample)) {
                map.put(sample, new ArrayList<>(Arrays.asList(i + 1)));
            }
        }
        for (Map.Entry item : map.entrySet()) {
            ArrayList<Integer> groupIndexes = ((ArrayList<Integer>)item.getValue());
            result.add(groupIndexes);
        }
        return result;
    }
}
