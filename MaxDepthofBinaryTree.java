public class MaxDepthofBinaryTree {
    static int max = 0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        max = -1000000000;
        dfs(root, 0);
        return max;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return ;

        if (depth > max) {
            max = depth;
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
