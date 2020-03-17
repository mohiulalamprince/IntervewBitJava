public class InvertBinaryTree {
    static TreeNode head1;
    static TreeNode head2;

    public static void main(String args[]) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode newNode = new TreeNode(root.val);

        newNode.right = invertTree(root.left);
        newNode.left = invertTree(root.right);
        return newNode;
    }
}
