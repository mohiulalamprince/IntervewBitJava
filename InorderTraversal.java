import java.util.ArrayList;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(PreorderTraversal.TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        inorder(A, result);
        return result;
    }

    public static void inorder(PreorderTraversal.TreeNode A, ArrayList<Integer> result) {
        if (A == null) return;

        if (A.left != null)
            inorder(A.left, result);
        result.add(A.val);

        if (A.right != null)
            inorder(A.right, result);
    }
}
