import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String args[]) {
        System.out.println(largestRectangleArea(new ArrayList<>(Arrays.asList(47, 69, 67, 97, 86, 34, 98, 16, 65, 95, 66, 69, 18, 1, 99, 56, 35, 9, 48, 72, 49, 47, 1, 72, 87, 52, 13, 23, 95, 55, 21, 92, 36, 88, 48, 39, 84, 16, 15, 65, 7, 58, 2, 21, 54, 2, 71, 92, 96, 100, 28, 31, 24, 10, 94, 5, 81, 80, 43, 35, 67, 33, 39, 81, 69, 12, 66, 87, 86, 11, 49, 94, 38, 44, 72, 44, 18, 97, 23, 11, 30, 72, 51, 61, 56, 41, 30, 71, 12, 44, 81, 43, 43, 27))));
    }

    public static int largestRectangleArea(ArrayList<Integer> A) {
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
