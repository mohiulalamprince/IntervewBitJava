public class miu03 {
    public static int isRapidlyIncreasing(int[] a) {
        int result = 0;
        long[] qsum = new long[a.length];

        /*
         * You may assume that the input array parameter is not null and that it contains at least one element.
         */
        qsum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            qsum[i] += (qsum[i-1] + a[i]);
        }
        for (int i = 1; i < qsum.length; i++) {
            long sumValue = 2l * qsum[i-1];
            if (sumValue >= a[i]) return 0;
        }
        return 1;
    }
    public static void main(String args[]) {
        System.out.println(isRapidlyIncreasing(new int[]{1, 3, 9, 27}));
        System.out.println(isRapidlyIncreasing(new int[]{1, 3, 200, 500}));
        System.out.println(isRapidlyIncreasing(new int[]{1}));
        System.out.println(isRapidlyIncreasing(new int[]{1, 3, 9, 26}));
        System.out.println(isRapidlyIncreasing(new int[]{1, 3, 7, 26}));
        System.out.println(isRapidlyIncreasing(new int[]{1, 3, 8, 26}));
        System.out.println(isRapidlyIncreasing(new int[]{1990000002, 2000000005}));
    }
}
