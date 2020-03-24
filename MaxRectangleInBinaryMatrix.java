import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleInBinaryMatrix {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1, 0)));
        A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 1, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0)));

        System.out.println(maximalRectangle(A));
    }

    public static int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int result = 0;
        if (A.size() == 0) return 0;
        result = largestRectangleArea(A.size(), A.get(0).size(), A.get(0));

        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 1) A.get(i).set(j, A.get(i).get(j) + A.get(i - 1).get(j));
            }
            result = Math.max(result, largestRectangleArea(A.size(), A.get(i).size(), A.get(i)));
        }
        return result;
    }

    public static int largestRectangleArea(int r, int c, ArrayList<Integer> A) {
        int maxArea = -1000000000;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < A.size()){
            if (stack.empty() || A.get(stack.peek()) <= A.get(i)) {
                stack.add(i);
                i++;
            } else {

                int top = stack.peek();
                stack.pop();
                int topValue = A.get(top);
                int currentArea = topValue * (stack.empty() ? i : (i - stack.peek() - 1));
                if (currentArea > maxArea)
                    maxArea = currentArea;
            }
        }

        while (stack.empty()== false) {
            int top = stack.peek();
            stack.pop();
            int topValue = A.get(top);
            int currentArea = topValue * (stack.empty() ? i : i- stack.peek() - 1);
            if (currentArea > maxArea)
                maxArea = currentArea;
        }
        return maxArea;
    }
}
