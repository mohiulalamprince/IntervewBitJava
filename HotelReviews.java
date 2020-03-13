import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class HotelReviews {

    static class Node {
        char c;
        ArrayList<Node> child;

        Node(char c) {
            this.c = c;
            this.child = new ArrayList<>();
        }
    }

    static Node trie;

    public static void insert(String str) {
        int j = 0;
        Node ptr = trie;

        for (int i = 0; i < str.length(); i++) {

            char next = str.charAt(i);
            boolean found = false;
            for (j = 0; j < ptr.child.size(); j++) {

                if (ptr.child.get(j).c == next) {
                    found = true;
                    ptr = ptr.child.get(j);
                    break;
                }
            }
            if (found == false) {
                ptr.child.add(new Node(next));
                ptr = ptr.child.get(ptr.child.size() - 1);
            }
        }
        ptr.child.add(new Node('*'));
    }

    public static boolean search(String str) {
        Node ptr = trie;
        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            char next = str.charAt(i);
            boolean found = false;
            for (j = 0; j < ptr.child.size(); j++) {
                if (ptr.child.get(j).c == next) {
                    found = true;
                    ptr = ptr.child.get(j);
                    break;
                }
            }
            if (found == false) {
                return false;
            }
        }
        for (int i = 0; i < ptr.child.size(); i++) {
            if (ptr.child.get(i).c == '*')
                return true;
        }
        return false;
    }

    public static void main(String args[]) {

        trie = new Node('S');
        /*insert("abcdef");
        insert("abde");
        insert("bcd");
        insert("zabc");
        insert("a");
        insert("abczx");

        boolean found = search("abc");
        System.out.println(found);

        found = search("zabc");
        System.out.println(found);

        found = search("abcz");
        System.out.println(found);

        found = search("abczx");
        System.out.println(found);
        */
        ArrayList<Integer> result = solve("cool_ice_wifi", new ArrayList(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")));
        result.forEach(x -> System.out.println(x));
    }

    static class Hotel {
        int id;
        int rating;

        public Hotel(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }
    }
    public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Hotel> result = new ArrayList<>();

        String[] goodWords = A.split("_");
        for (int i = 0; i < goodWords.length; i++) {
            insert(goodWords[i]);
        }

        boolean found = false;
        for (int i = 0; i < B.size(); i++) {
            String[] words = B.get(i).split("_");

            int counter = 0;
            for (int j = 0; j < words.length; j++) {
                found = search(words[j]);
                if (found) counter++;
            }
            result.add(new Hotel(i, counter));
        }
        Collections.sort(result, Comparator.comparing(Hotel::getRating).reversed().thenComparing(Hotel::getId));
        return new ArrayList<>(result.stream().map(x -> x.id).collect(Collectors.toList()));
    }
}
