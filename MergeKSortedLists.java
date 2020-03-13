import java.util.ArrayList;

public class MergeKSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null;}
    }

    static ListNode head;

    public static void main(String args[]) {

        ListNode first = new ListNode(11);
        first.next = new ListNode(11);
        first.next.next = new ListNode(11);

        ListNode second = new ListNode(4);
        second.next = new ListNode(11);
        second.next.next = new ListNode(10);

        ListNode third = new ListNode(3);
        third.next = new ListNode(8);
        third.next.next = new ListNode(9);

        ArrayList<ListNode> input = new ArrayList<>();
        //input.add(first);
        //input.add(second);
        //input.add(third);
        //String str = "10 9 8 20 38 44 55 65 66 79 87 2 68 72 5 5 55 61 73 89 2 30 73 4 28 73 84 96 3 54 82 83 5 15 33 38 94 100 1 4 5 22 32 42 64 86 2 11 78";
        String str = "6 9 17 20 64 69 72 74 77 78 85 3 62 84 98 9 9 23 30 44 58 59 71 84 95 9 9 12 20 25 26 60 63 70 86 3 25 64 66 4 7 39 44 100";
        String[] parts = str.split(" ");

        ListNode forth = null;
        for (int i = 0; i < parts.length; i++) {
            insert(new ListNode(Integer.parseInt(parts[i])));
        }
        forth = head;
        head = null;
        input.add(forth);

        ListNode output = mergeKLists(input);
        print(output);
    }

    public static void insertWithSort(ListNode node) {
        if (head == null) {
            head = node;
        } else {

            ListNode ptr = head;
            ListNode previous = null;

            while (ptr != null) {
                previous = ptr;

                if (previous.next != null && previous.val < node.val && node.val <= previous.next.val) {
                    break;
                } else if (previous.val > node.val) {
                    node.next = previous;
                    head = node;
                    return ;
                }
                ptr = ptr.next;
            }

            node.next = previous.next;
            previous.next = node;
        }
    }

    public static void insert(ListNode node) {
        if (head == null) {
            head = node;
        } else {

            ListNode ptr = head;
            ListNode previous = null;

            while (ptr != null) {
                previous = ptr;
                ptr = ptr.next;
            }

            node.next = previous.next;
            previous.next = node;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {

        for (int i = 0; i < a.size(); i++) {
            ListNode ptr = a.get(i);
            while (ptr != null) {
                ListNode newNode = new ListNode(ptr.val);
                insertWithSort(newNode);
                ptr = ptr.next;
            }
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
