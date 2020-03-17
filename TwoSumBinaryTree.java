import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoSumBinaryTree {
    static int answer = 0;

    public static void main(String args[]) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        //root.right.right = new TreeNode(40);

        System.out.println(t2Sum(root, 19));
    }

    public static int t2Sum(TreeNode A, int B) {
        answer = 0;
        traverse(A, B);
        return answer;
    }

    public static void traverse(TreeNode root, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        result.clear();
        inorder(root, result);

        int start = 0;
        int end = result.size() -1;

        while (start < end) {
            int sum = result.get(start) + result.get(end);

            if (sum < target) {
                start ++;
            } else if (sum > target){
                end--;
            } else {
                answer = 1;
                break;
            }
        }
    }

    public static void inorder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return ;

        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
