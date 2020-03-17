import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInTree {
    static TreeNode head = null;
    static int counter = 0;
    static int answer = 0;
    public static void main(String args[]) {
        head = new TreeNode(2);
        head.left = new TreeNode(1);
        head.right = new TreeNode(3);
        //head.right.left = new TreeNode(4);

        int result = kthsmallest(head, 2);
        System.out.println(result);
    }

    public static int kthsmallest(TreeNode A, int B) {
        counter = 0;
        answer = 0;
        traverse(A, B);
        return answer;
    }

    public static void traverse(TreeNode root, int target) {
        if (root == null) return ;

        traverse(root.left, target);
        counter ++;
        if (counter == target) {
            answer = root.val;
            return ;
        }
        traverse(root.right, target);
    }
}
