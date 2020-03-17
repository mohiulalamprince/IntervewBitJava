import java.util.ArrayList;

public class PathSum {
    static int answer = 0;
    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(18);

        root.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        System.out.println(hasPathSum(root, 32));
    }

    public static int hasPathSum(TreeNode A, int B) {
        answer = 0;
        dfs(A, B, 0);
        return answer;
    }

    public static void dfs(TreeNode root, int target, int sum) {
        if (root == null) return ;
        if (root.left == null && root.right == null && sum + root.val == target) {
            answer = 1;
            return ;
        }

        dfs(root.left, target, sum + root.val);
        dfs(root.right, target, sum + root.val);
    }
}
