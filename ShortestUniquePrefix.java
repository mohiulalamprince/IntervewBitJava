import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {
    static ArrayList<String> result = new ArrayList<>();
    static class Node {
        char c;
        int frequency;
        ArrayList<Node> child;

        Node(char c) {
            this.c = c;
            this.frequency = 0;
            this.child = new ArrayList<>();
        }
        Node(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
            this.child = new ArrayList<>();
        }

        Node(char c, int frequency, ArrayList<Node> child) {
            this.c = c;
            this.frequency = frequency;
            this.child = new ArrayList<>(child);
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
                    ptr.child.get(j).frequency++;
                    ptr = ptr.child.get(j);
                    break;
                }
            }
            if (found == false) {
                ptr.child.add(new Node(next, 1));
                ptr = ptr.child.get(ptr.child.size() - 1);
            }
        }
        ptr.child.add(new Node('*', 1));
    }

    public static String search(String str) {
        Node ptr = trie;
        int j = 0;

        for (int i = 0; i < str.length(); i++) {
            char next = str.charAt(i);
            boolean found = false;

            for (j = 0; j < ptr.child.size(); j++) {
                if (ptr.child.get(j).c == next) {
                    if (ptr.child.get(j).frequency == 1) {
                        return str.substring(0, i + 1);
                    }
                    found = true;
                    ptr = ptr.child.get(j);
                    break;
                }
            }
            if (found == false) {
                return "";
            }
        }
        for (int i = 0; i < ptr.child.size(); i++) {
            if (ptr.child.get(i).c == '*')
                return str;
        }
        return "";
    }

    public static void main(String args[]) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("bearcat", "bert"));

        result = prefix(input);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<String> prefix(ArrayList<String> A) {
        result.clear();
        trie = new Node('#', 1);

        for (int i = 0; i < A.size(); i++) {
            insert(A.get(i));
        }

        for (int i = 0; i < A.size(); i++) {
            String retString = search(A.get(i));
            result.add(retString);
        }
        return result;
    }
}
