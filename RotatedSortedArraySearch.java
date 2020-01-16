import java.util.*;

public class RotatedSortedArraySearch {
    static class Node {
        int data;
        int index;
        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public static int binary_search(int lo, int hi, List<Node> A, int B) {

        if (lo >= hi) return -1;

        int mid = (lo + hi) / 2;
        if (A.get(mid).data > B) return binary_search(lo, mid, A, B);
        else if (A.get(mid).data < B) return binary_search(mid + 1, hi, A, B);
        else return A.get(mid).index;
    }

    public static int search(final List<Integer> A, int B) {
        List<Node> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            C.add(new Node(i, A.get(i)));
        }

        C.sort(Comparator.comparing(Node::getData));

        return binary_search(0, C.size(), C, B);
    }

    public static void main(String args[]) {
        List<Integer> A = Arrays.asList(4, 3, 2, 0, 1);
        System.out.println(search(A, 0));
    }
}
