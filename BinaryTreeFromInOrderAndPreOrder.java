import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeFromInOrderAndPreOrder {
    static TreeNode head;
    static int preOrderIndex = 0;

    public static void main(String args[]) {
        buildTree(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(2, 1, 3)));
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        head = null;
        preOrderIndex = 0;
        head = createTree(A, B, 0, A.size() - 1);
        postorder(head);
        return head;
    }

    public static TreeNode createTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int start, int end) {
        if (start > end) return null;

        int rootValue = preorder.get(preOrderIndex);
        TreeNode root = new TreeNode(rootValue);
        preOrderIndex ++;

        if (start == end) return new TreeNode(rootValue);

        int index = findRoot(inorder, start, end, rootValue);

        root.left = createTree(preorder, inorder, start, index - 1);
        root.right = createTree(preorder, inorder, index + 1, end);
        return root;
    }

    public static int findRoot(ArrayList<Integer> inorder, int start, int end, int rootValue) {
        int i = 0;
        for (i = start; i <= end; i++) {
            if (inorder.get(i) == rootValue)
                break;
        }
        return i;
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;

        System.out.println(root.val);
        postorder(root.left);
        postorder(root.right);
    }
}
