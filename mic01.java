import java.util.Arrays;

public class mic01 {
    public static boolean isUnique(int[] a, int currentIndex, int x) {
        if (a[currentIndex] != x) return true;
        else return false;
    }

    public static int hasNValues(int a[], int n) {
        if (a.length == 0 && n == 1) return 0;
        if (a.length == 0 && n == 0) return 1; // if a.length is equal zero and n = 0 then condition is valid.
        if (n == 0 || a.length == 0) return 0;

        int k =0;
        int[] result = new int[n];
        int[] copyOfa = a;

        Arrays.sort(copyOfa);
        result[k++] = copyOfa[0];
        for (int i = 1; i < copyOfa.length; i++) {
            if (isUnique(copyOfa, i-1, copyOfa[i])) {
                if (k + 1 > n) return 0;
                result[k++] = copyOfa[i];
            }
        }
        if (k == n) return 1;
        else return 0;
    }

    public static void main(String args[]) {
        System.out.println(hasNValues(new int[] {}, 1));
        System.out.println(hasNValues(new int[] {1, 2, 2, 1}, 2));
        System.out.println(hasNValues(new int[] {1, 1, 1, 8, 1, 1, 1, 3, 3}, 3));
        System.out.println(hasNValues(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));
        System.out.println(hasNValues(new int[] {1, 2, 2, 1}, 3));
        System.out.println(hasNValues(new int[] {1, 1, 1, 8, 1, 1, 1, 3, 3}, 2));
        System.out.println(hasNValues(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 20));
    }
}
