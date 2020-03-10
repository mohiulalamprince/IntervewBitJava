import java.util.*;

public class WindowString {
    static class Pair<K, V> {
        K k;
        V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }
        public V getValue() {
            return v;
        }
    }
    public static void main(String args[]) {
        String output = minWindow("TquFYBhPdnv7B40ibLTOIaKFVPpzaTx6z5svvfHI02Ul050z0fMC2gmuHDoV8mfVSecxZKink1fdgcFO7IqzSbr15xUXkixHRyUs0PGBHrMQeCEsVPa7z4N55VDSIzKjRFcqMai1i3LfPhwRavhMN28ZCo4rnyh0Nyjicdwf6w5krmUguK13WSsGIwdDwH7Rqy2a8iQ0s0yhWXGsrUny05GVq1hwvMKcg2MASfKj6a7csLe5NPYX5BuIdfbFQSuLQ2jViwylwOhQUOqsqcYVVE0mra3MCa54hbs5K4ChOSmaUuNgmY1tn25j2aSfJp5MywnA4csDNd6AgdxvjdZr3OLIwiDL69r6O3dS4eNfWK4dTVsh3bT0XR8ZYcnvQ0A8YIHK9LjuYwVGomGcM2IRnwI4zR28APMWIithrHGGF5gyEWuhZLTJOfpegMUmDLziS4KeOjUiQZ0lJij1frdYqxowUu4RECiX9mBLMxx2mJRJf6dfHQ9pAxCGVxP4rKk3Bgyyhpu17iK2mjVuLCg9qnfpjBkhhCpFQ8iHXQ6g67rusAx9jmeGuPfSdxg1FgFG6X223dxEsKUlUJEhndb6eycnSQiovC5oWDiNTEmWK7YfmfBZP1HXaKLSLfmwy2Uhr68Td", "dB");
        System.out.println(output);
    }

    public static String minWindow(String A, String B) {
        String result = "";
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < B.length(); i++) {
            if (!required.containsKey(B.charAt(i))) {
                required.put(B.charAt(i), 1);
            }
            else {
                int cnt = required.get(B.charAt(i));
                required.put(B.charAt(i), cnt + 1);
            }
        }

        int endPos = 0;
        int startPos = 0;
        int target = 0;
        int min = 1000000000;
        while (endPos < A.length()) {

            if (required.containsKey(A.charAt(endPos))) {
                queue.add(new Pair(A.charAt(endPos), endPos));
                if (current.containsKey(A.charAt(endPos))) {
                    int currentCounter = current.get(A.charAt(endPos));
                    current.put(A.charAt(endPos), currentCounter + 1);
                } else {
                    current.put(A.charAt(endPos), 1);
                }
                int counter = (required.get(A.charAt(endPos)));
                if (current.get(A.charAt(endPos)) <= counter) {
                    if (target == 0) {
                        startPos = endPos;
                    }
                    target++;
                }
            }

            if (target == B.length()) {
                while (true) {
                    Pair<Character, Integer> pair = queue.peek();
                    if (required.containsKey((Character)pair.k)) {
                        int rc = required.get((Character)pair.k);
                        int cc = current.get((Character)pair.k);

                        if (cc > rc) {
                            queue.poll();
                            current.put(pair.k, cc - 1);
                            startPos = (int)queue.peek().v;

                        } else {
                            break;
                        }
                    }
                }
                if (endPos - startPos + 1 <= min) {
                    min = endPos - startPos + 1;
                    result = A.substring(startPos, endPos + 1);
                }
            }

            endPos++;
        }
        return result;
    }
}
