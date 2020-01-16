public class PrimeNumber {
    public static void primeGen(int n) {
        boolean[] table = new boolean[n + 1];
        for (int i = 3; i < n; i += 2) table[i] = true;

        for (int i = 3; i * i < n; i += 2) {
            if (table[i] == true) {
                for (int j = i * i; j < n; j += i) {
                    table[j] = false;
                }
            }
        }

        for (int i = 3; i < n; i += 2) {
            if (table[i] == true) {
                System.out.println(i + " ");
            }
        }
    }

    public static int subString(String mainString, String queryString) {
        int i = 0;
        boolean found = false;
        int retIndex = -1;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < mainString.length(); i++) {
            int counter = 0;
            if (mainString.charAt(i) == queryString.charAt(0)) {
                retIndex = i;
                for (int j = 0; j < queryString.length(); j++) {
                    if (mainString.charAt(i + j) == queryString.charAt(j)) {
                        counter++;
                    } else {
                        retIndex = -1;
                        break;
                    }
                }
                if (counter == queryString.length()) {
                    found = true;
                    break;
                }
            }
        }
        if (found == true) {
            return retIndex;
        }
        return retIndex;
    }

    public static int factor(int n) {
        int factorCounter = 1;
        int i = 0;

        for (i = 2; i * i <= n; i++) {
            int counter = 0;
            while (n % i == 0) {
                n /= i;
                counter += 1;
            }
            if (counter > 0) {
                factorCounter *= (counter + 1);
            }
        }
        if (n > 1) {
            factorCounter *= 2;
        }

        return factorCounter;
    }

    public static void main(String args[]) {
        //primeGen(100);
        //System.out.println(subString("hello world", "test"));
        //System.out.println(subString("hello world", "wor"));

        System.out.println(factor(24));
        System.out.println(factor(14));
        System.out.println(factor(7));
    }
}
