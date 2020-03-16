import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreeFromInorderAndPostOrder {
    static TreeNode head = null;
    static int postOrderIndex;

    public static void main(String args[]) {
        //head = buildTree(new ArrayList<>(Arrays.asList(7, 5, 6, 2, 3, 1, 4)), new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 2, 7)));
        head = buildTree(new ArrayList<>(Arrays.asList(4, 8, 2, 5, 1, 6, 3, 7)),
                new ArrayList<>(Arrays.asList(8, 4, 5, 2, 6, 7, 3, 1)));

        ArrayList<Integer> result = new ArrayList<>();
        preorder(head, result);
        result.forEach(x -> System.out.println(x));
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        head = null;
        postOrderIndex = A.size() - 1;
        head = createTree(head, A, B, 0, A.size() - 1);
        return head;
    }

    public static TreeNode createTree(TreeNode root, ArrayList<Integer> inorder, ArrayList<Integer> postOrder, int start, int end) {
        if (start > end) return null;

        int rootValue = postOrder.get(postOrderIndex);
        root = new TreeNode(rootValue);

        postOrderIndex --;
        if (start == end) return root;

        int index = findRoot(inorder, start, end, rootValue);

        root.right = createTree(root, inorder, postOrder, index + 1, end);
        root.left = createTree(root, inorder, postOrder, start, index - 1);
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

    public static void preorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;

        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
