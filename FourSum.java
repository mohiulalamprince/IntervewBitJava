import java.util.*;

public class FourSum {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> result = fourSum(new ArrayList<>(Arrays.asList(1, 0, -1, 0, -2, 2)), 0);
        result.forEach(x -> {
            x.forEach(y -> System.out.print(y));
            System.out.println();
        });
    }
    public static ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> hash = new HashSet<>();
        Collections.sort(A);

        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int k = j + 1;
                int l = A.size() - 1;

                while (k < l) {
                    if (k == A.size()) continue;
                    int sum = A.get(i) + A.get(j) + A.get(k) + A.get(l);
                    if (sum > target) l--;
                    else if (sum < target) k++;
                    else if (sum == target) {
                        if (!hash.contains(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k), A.get(l))))) {
                            result.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k), A.get(l))));
                            hash.add(new ArrayList<>(Arrays.asList(A.get(i), A.get(j), A.get(k), A.get(l))));
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
