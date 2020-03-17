import java.util.ArrayList;

public class RootToLeafPathsWithSum {
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {
        TreeNode root = new TreeNode(12);
        root.right = new TreeNode(14);
        root.right.right = new TreeNode(18);

        root.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        pathSum(root, 32);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        answer = 0;
        ArrayList<Integer> paths = new ArrayList<>();
        dfs(A, B, paths,0);
        return result;
    }

    public static void dfs(TreeNode root, int target, ArrayList<Integer> paths, int sum) {
        if (root == null) return ;
        if (answer == 1) return ;
        if (root.left == null && root.right == null && sum + root.val == target) {
            paths.add(root.val);
            result.add(new ArrayList<>(paths));
            answer = 1;
            return ;
        }

        paths.add(root.val);
        dfs(root.left, target, paths, sum + root.val);
        paths.remove(paths.size() - 1);

        paths.add(root.val);
        dfs(root.right, target, paths, sum + root.val);
        paths.remove(paths.size() - 1);
    }
}
