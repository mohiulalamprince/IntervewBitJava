import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {
    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("aacbbbcdaefgh"));
    }

    public static int lengthOfLongestSubstring(String A) {
        int max = -1000000000;
        int startPos = 0;
        int endPos = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            int charValue = (int)(A.charAt(i));
            if (map.containsKey(charValue)) {
                if (startPos < map.get(charValue) + 1) {
                    startPos = map.get(charValue) + 1;
                }
                endPos++;
                map.put(charValue, i);
            } else {
                map.put(charValue, i);
                endPos++;
            }

            if (max < (endPos - startPos)) max = endPos - startPos;
        }
        return max;
    }
}
