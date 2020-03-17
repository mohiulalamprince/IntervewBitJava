public class MinDepthofBinaryTree {
    static int min = 0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(18);

        root.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(6);

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        min = 2000000000;

        dfs(root, 1);
        return min;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return ;

        if (root.left == null && root.right == null) {
            if (min > depth) min = depth;
            return ;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
