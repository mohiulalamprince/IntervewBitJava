public class ImplementPowerFunction {
    public static long pow(long x, long n, long d) {
        if (x == 0) return 0;
        if (x < 0) x += d;
        if (n == 0) return 1 % d;
        if (n == 1) return x % d;
        if (n == 2) return (((x % d) * (x % d)) %d);

        if (n % 2 == 0) {
            long res = pow(x, n / 2, d) % d;
            return (((res % d) * (res % d)) % d);
        } else {
            return ((x * pow(x, n-1, d)) % d);
        }
    }

    public static void main(String args[]) {
        System.out.println(pow(71045970l, 41535484l, 64735492l));
    }
}
