import java.util.ArrayList;

public class SortedArrrayToBalancedBST {
    static TreeNode head;

    public static void main(String args[]) {
        sortedArrayToBST(new int[] {1});
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        head = createTree(head, A, 0, A.length - 1);
        return head;
    }

    public static TreeNode createTree(TreeNode root, int[] inorder, int start, int end) {
        if (start > end) return null;

        int index = (start + end) / 2;

        root = new TreeNode(inorder[index]);

        root.left = createTree(root, inorder, start, index - 1);
        root.right = createTree(root, inorder, index + 1, end);
        return root;
    }
}
