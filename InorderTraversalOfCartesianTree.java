import java.util.ArrayList;
import java.util.Arrays;

public class InorderTraversalOfCartesianTree {
    static TreeNode head = null;

    public static void main(String args[]) {
        buildTree(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    static TreeNode buildTree(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();

        head = createTree(head, A, 0, A.size() - 1);

        /*TreeNode ptr = head;
        inorder(ptr, result);
        result.forEach(x -> System.out.println(x));
        */
        return head;
    }

    public static TreeNode createTree(TreeNode root, ArrayList<Integer> inorder, int start, int end) {
        if (start == end) return new TreeNode(inorder.get(start));
        if (start > end) return null;

        int index = findMax(inorder, start, end);

        root = new TreeNode(inorder.get(index));

        root.left = createTree(root, inorder, start, index - 1);
        root.right = createTree(root, inorder, index + 1, end);
        return root;
    }

    public static void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public static int findMax(ArrayList<Integer> inorder, int start, int end) {
        int max = -2000000000;
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (max < inorder.get(i)) {
                max = inorder.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
