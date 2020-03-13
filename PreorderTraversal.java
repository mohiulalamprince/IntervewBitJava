import java.util.ArrayList;

public class PreorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> result = preorderTraversal(root);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        preorder(A, result);
        return result;
    }

    public static void preorder(TreeNode A, ArrayList<Integer> result) {
        if (A == null) return;
        result.add(A.val);

        if (A.left != null)
            preorder(A.left, result);
        if (A.right != null)
            preorder(A.right, result);
    }
}
