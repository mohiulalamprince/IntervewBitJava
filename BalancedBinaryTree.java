public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static boolean notBalanced = false;

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = isBalanced(root);
        System.out.println(result);

        notBalanced = false;

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        result = isBalanced(root);
        System.out.println(result);
    }

    public static int isBalanced(TreeNode A) {
        int result = 0;
        result = dfs(A);
        return notBalanced ? 0 : 1;
    }

    public static int dfs(TreeNode root) {
        if (notBalanced) return -1;
        if (root.right == null && root.left == null) return 0;

        int leftCount = 0;
        int rightCount = 0;

        if (root.left != null)
            leftCount += dfs(root.left) + 1;

        if (root.right != null)
            rightCount += dfs(root.right) + 1;

        if (Math.abs(leftCount - rightCount) > 1) {
            notBalanced = true;
            return 0;
        }
        return Math.max(leftCount, rightCount);
    }
}
