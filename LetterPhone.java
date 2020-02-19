import java.util.*;
import java.util.stream.Collectors;

public class LetterPhone {
    private static Map<Integer, String> valueToCharMap = new HashMap<>();
    private static Queue<StringBuilder> result = new LinkedList<>();

    static void bfs(String digits) {
        String initial = valueToCharMap.get(digits.charAt(0) - 48);
        if (digits.charAt(0) - 48 == 0)
            result.add(new StringBuilder().append("0"));
        else if (digits.charAt(0) - 48 == 1) {
            result.add(new StringBuilder().append("1"));
        }
        else {
            result.add(new StringBuilder().append(initial.charAt(0)));
            result.add(new StringBuilder().append(initial.charAt(1)));
            result.add(new StringBuilder().append(initial.charAt(2)));
            if (digits.charAt(0) -48 == 7 || digits.charAt(0) - 48 == 9)
                result.add(new StringBuilder().append(initial.charAt(3)));
        }

        for (int j = 1; j < digits.length(); j++) {
            String chars = valueToCharMap.get(digits.charAt(j) - 48);
            int length = result.size();
            for (int i = 0; i < length; i++) {
                StringBuilder element = result.poll();
                for (int k = 0; k < chars.length(); k++) {
                    String item = element.toString() + chars.charAt(k);
                    result.add(new StringBuilder(item));
                }
            }
        }
    }

    public static ArrayList<String> letterCombinations(String A) {
        valueToCharMap.put(0, "0");
        valueToCharMap.put(1, "1");
        valueToCharMap.put(2, "abc");
        valueToCharMap.put(3, "def");
        valueToCharMap.put(4, "ghi");
        valueToCharMap.put(5, "jkl");
        valueToCharMap.put(6, "mno");
        valueToCharMap.put(7, "pqrs");
        valueToCharMap.put(8, "tuv");
        valueToCharMap.put(9, "wxyz");

        bfs(A);

        ArrayList<String> processedResult = new ArrayList<>();
        for (StringBuilder sb : result) {
            processedResult.add(sb.toString());
        }
        return processedResult;
        //return new ArrayList<>(result.stream().map(x -> x.toString()).collect(Collectors.toList()));
    }

    public static void main(String args[]) {
        ArrayList<String> output = letterCombinations("11");
        output.forEach(x -> System.out.println(x));
    }
}
