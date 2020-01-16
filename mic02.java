public class mic02 {
    public static int hasSingleMaximum(int[] a) {
        if (a.length == 0) return 0;

        int maxi = Integer.MIN_VALUE;
        int maxPos = -1;
        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            if (maxi < a[i]) {
                maxi = a[i];
                maxPos = i;
            }
        }

        counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (maxPos != i && maxi == a[i]) {
                counter ++;
            }
        }
        if (counter == 0) return 1;
        else return 0;
    }
    public static void main(String args[]) {
        System.out.println(hasSingleMaximum(new int[]{1, 2, 3, 1, 0}));
        System.out.println(hasSingleMaximum(new int[]{18}));
        System.out.println(hasSingleMaximum(new int[]{1, 2, 3, 0, 1, 3}));
        System.out.println(hasSingleMaximum(new int[]{13, 1, 13, 2, 13, 0, 13, 1, 13}));
        System.out.println(hasSingleMaximum(new int[]{}));
        System.out.println(hasSingleMaximum(new int[]{-6, -6, -6, -6, -6, -6, -6}));
        System.out.println(hasSingleMaximum(new int[]{-6}));
    }
}
