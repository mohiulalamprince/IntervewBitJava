public class SampleTest1 {
    public static int stricktlyGetter(int A[]) {
        int result = 0;
        int i = 0;
        if (A.length % 2 == 1) {
            int targetNumber = A[A.length/2  + 1];
            for (i = 0; i < A.length; i++) {
               if (i == A.length/2 + 1) continue;
               else if (targetNumber < A[i]) {
                   continue;
               } else {
                   return 0;
               }
            }
            if (i == A.length) return 1;
        }
        return 0;
    }

    public static char[] subString(char[] c, int startPos, int length) {
        if (startPos < 0 || startPos > c.length) return null;
        if (c.length < startPos + length || startPos + length < 0) return null;

        char ret[] = new char[length];

        for (int i = startPos; i < startPos + length; i++) {
            ret[i-startPos] = c[i];
        }
        return ret;
    }

    public static int reverse(int n) {
        int result = 0;
        int counter = 0;
        if (n == 0) return 0;
        while (n > 0) {
            if (counter > 0) result *= 10;
            result += n % 10;
            n /= 10;
            counter ++;
        }
        return result;
    }

    public static int partition(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) sum += A[i];

        int subSum = 0;
        int rightIndex = -1;
        for (int i = 0; i < A.length - 1; i++) {
            subSum += A[i];
            if (sum - A[i + 1] - subSum == subSum) {
                rightIndex = i + 1;
            }
        }
        return rightIndex;
    }

    public static void main(String args[]) {
        int A[] = {1, 5, 3, 1, 1, 1, 1, 1, 1};
        //System.out.println(stricktlyGetter(A));
        char[] c = {'a', 'b', 'c'};
        System.out.println(subString(c, 1, 0) == null ? "" : subString(c, 1, 0));
        System.out.println(reverse(Math.abs(12345)));
        System.out.println(partition(new int[] {1, 5, 3, 1, 1, 1, 1, 1, 1}));
        System.out.println(partition(new int[] {2, 1, 1, 1, 2, 1, 7}));
        System.out.println(partition(new int[] {1, 2, 3}));
        System.out.println(partition(new int[] {3, 4, 5, 10}));
        System.out.println(partition(new int[] {1, 2, 10, 3, 4}));
        System.out.println(partition(new int[] {6, 6, 6}));
    }
}
