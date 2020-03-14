import java.sql.PreparedStatement;
import java.util.ArrayList;

public class IdenticalBinaryTree {

    static boolean same = true;
    public static void main(String args[]) {
        BalancedBinaryTree.TreeNode root1 = new BalancedBinaryTree.TreeNode(1);
        root1.left = new BalancedBinaryTree.TreeNode(2);
        root1.right = new BalancedBinaryTree.TreeNode(3);

        BalancedBinaryTree.TreeNode root2 = new BalancedBinaryTree.TreeNode(1);
        root2.left = new BalancedBinaryTree.TreeNode(2);
        root2.right = new BalancedBinaryTree.TreeNode(3);
        //root2.left.left = new BalancedBinaryTree.TreeNode(4);

        int result = isSameTree(root1, root2);

        System.out.println(result);
    }

    public static int isSameTree(BalancedBinaryTree.TreeNode root1, BalancedBinaryTree.TreeNode root2) {
        if (root1 == null && root2 == null) return 1;
        if (root1 == null || root2 == null) return 0;
        if (root1.val != root2.val) return 0;

        return isSameTree(root1.left, root2.left) & isSameTree(root1.right, root2.right);
    }
}
