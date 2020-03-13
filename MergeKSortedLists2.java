import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists2 {
    static MergeKSortedLists.ListNode head;

    public static void main(String args[]) {
        MergeKSortedLists.ListNode first = new MergeKSortedLists.ListNode(11);
        first.next = new MergeKSortedLists.ListNode(11);
        first.next.next = new MergeKSortedLists.ListNode(11);

        MergeKSortedLists.ListNode second = new MergeKSortedLists.ListNode(4);
        second.next = new MergeKSortedLists.ListNode(11);
        second.next.next = new MergeKSortedLists.ListNode(10);

        MergeKSortedLists.ListNode third = new MergeKSortedLists.ListNode(3);
        third.next = new MergeKSortedLists.ListNode(8);
        third.next.next = new MergeKSortedLists.ListNode(9);

        ArrayList<MergeKSortedLists.ListNode> input = new ArrayList<>();
        input.add(first);
        input.add(second);
        input.add(third);

        mergeKLists(input);
        print(head);
    }

    public static MergeKSortedLists.ListNode mergeKLists(ArrayList<MergeKSortedLists.ListNode> a) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            MergeKSortedLists.ListNode current = a.get(i);

            while (current != null) {
                pQueue.add(current.val);
                current = current.next;
            }
        }

        while (!pQueue.isEmpty()) {
            int value = pQueue.remove();
            insert(new MergeKSortedLists.ListNode(value));
        }
        return head;
    }

    public static void insert(MergeKSortedLists.ListNode node) {
        if (head == null) {
            head = node;
        } else {

            MergeKSortedLists.ListNode ptr = head;
            MergeKSortedLists.ListNode previous = null;

            while (ptr != null) {
                previous = ptr;
                ptr = ptr.next;
            }

            node.next = previous.next;
            previous.next = node;
        }
    }

    public static void print(MergeKSortedLists.ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
