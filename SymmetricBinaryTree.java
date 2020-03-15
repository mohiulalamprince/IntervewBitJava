public class SymmetricBinaryTree {
    static BalancedBinaryTree.TreeNode B;

    public static void main(String args[]) {
        BalancedBinaryTree.TreeNode A = new BalancedBinaryTree.TreeNode(1);
        A.left = new BalancedBinaryTree.TreeNode(2);
        A.right = new BalancedBinaryTree.TreeNode(2);
        A.left.left = new BalancedBinaryTree.TreeNode(3);
        A.right.right = new BalancedBinaryTree.TreeNode(3);
        A.left.right = new BalancedBinaryTree.TreeNode(4);
        A.right.left = new BalancedBinaryTree.TreeNode(4);

        System.out.println(isSymmetric(A));

        A = new BalancedBinaryTree.TreeNode(1);
        A.left = new BalancedBinaryTree.TreeNode(2);
        A.right = new BalancedBinaryTree.TreeNode(2);
        A.left.right = new BalancedBinaryTree.TreeNode(3);
        A.right.right = new BalancedBinaryTree.TreeNode(3);
        System.out.println(isSymmetric(A));
    }

    public static int isSame(BalancedBinaryTree.TreeNode A, BalancedBinaryTree.TreeNode B) {
        if (A == null && B == null) return 1;
        if (A != null && B == null) return 0;
        if (A == null && B != null) return 0;

        if (A.val != A.val) return 0;

        return isSame(A.left, B.right) & isSame(A.right, B.left);
    }

    public static int isSymmetric(BalancedBinaryTree.TreeNode A) {
        int result = 0;
        result = isSame(A.left, A.right);
        return result;
    }
}
