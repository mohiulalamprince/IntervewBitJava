import java.util.ArrayList;

public class SumRootToLeafNumbers {
    static int totalSum = 0;

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(3);

        sumNumbers(root);
        System.out.println(totalSum);
    }

    public static int sumNumbers(TreeNode A) {
        totalSum = 0;
        ArrayList<Integer> paths = new ArrayList<>();
        dfs(A, paths);
        return totalSum;
    }

    public static void dfs(TreeNode root, ArrayList<Integer> paths) {
        if (root == null) return ;
        if (root.left == null && root.right == null) {
            paths.add(root.val);

            long currentSum = 0;
            for (int i = 0; i < paths.size(); i++) {
                currentSum = (currentSum * 10 + paths.get(i)) % 1003;
            }
            totalSum += (currentSum % 1003);
            totalSum %= 1003;
            paths.remove(paths.size() - 1);

            return ;
        }

        paths.add(root.val);
        dfs(root.left, paths);
        paths.remove(paths.size() - 1);

        paths.add(root.val);
        dfs(root.right, paths);
        paths.remove(paths.size() - 1);
    }
}
