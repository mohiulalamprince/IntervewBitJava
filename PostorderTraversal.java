import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String args[]) {
        PreorderTraversal.TreeNode root = new PreorderTraversal.TreeNode(1);
        root.left = new PreorderTraversal.TreeNode(2);
        root.right = new PreorderTraversal.TreeNode(3);
        root.left.left = new PreorderTraversal.TreeNode(4);
        root.left.right = new PreorderTraversal.TreeNode(5);
        root.right.left = new PreorderTraversal.TreeNode(6);
        root.right.right = new PreorderTraversal.TreeNode(7);

        ArrayList<Integer> result = postorderTraversal(root);
        result.forEach(x -> System.out.println(x));
    }

    public static ArrayList<Integer> postorderTraversal(PreorderTraversal.TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();

        postorder(A, result);
        return result;
    }

    public static void postorder(PreorderTraversal.TreeNode A, ArrayList<Integer> result) {
        Stack<PreorderTraversal.TreeNode> stack = new Stack<>();

        PreorderTraversal.TreeNode root = A;
        PreorderTraversal.TreeNode current = null;
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);

                root = root.left;
            }


            current = stack.pop();

            if (stack.empty()) break;
            root = stack.peek();

            if (!stack.empty() && root == current)
                root = root.right;
            else {
                result.add(current.val);
                root = null;
            }
        }
        if (current != null) {
            result.add(current.val);
        }
    }
}
