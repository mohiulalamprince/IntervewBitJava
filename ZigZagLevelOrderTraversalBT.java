import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ZigZagLevelOrderTraversalBT {
    static ArrayList<ArrayList<Integer>> nodeList = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(3);

        zigzagLevelOrder(root);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        result.clear();
        nodeList.clear();

        dfs(A, 1);

        int counter = 0;
        for (ArrayList<Integer> nodes : nodeList) {
            if (counter % 2 != 0)
                Collections.reverse(nodes);
            result.add(nodes);
            counter ++;
        }

        return result;
    }

    public static void dfs(TreeNode root, int depth) {
        if (root == null) return ;

        if (nodeList.size() < depth) {
            nodeList.add(new ArrayList<>(Arrays.asList(root.val)));
        } else {
            nodeList.get(depth-1).add(root.val);
        }

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
