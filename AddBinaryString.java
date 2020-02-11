import java.util.Arrays;

public class AddBinaryString {
    public static void main(String args[]) {
        String x = addBinaryLarge("1010", "110");
        System.out.println(x);
    }

    public static String addBinary(String A, String B) {
        int n = convertBinaryToInt(A);
        int m = convertBinaryToInt(B);
        System.out.println(n + " " + m);
        return convertIntToBinary(n + m);
    }

    public static int convertBinaryToInt(String A) {
        int sum = 0;
        for (int i = 0; i < A.length(); i++) {
            sum += Math.pow(2, A.length()-i-1) * (A.charAt(i) - 48);
        }
        return sum;
    }

    public static String convertIntToBinary(int A) {
        StringBuilder s = new StringBuilder();
        while (A > 0) {
            int mod = A % 2;
            A /= 2;
            s.append(Integer.toString(mod));
        }
        return s.reverse().toString();
    }

    public static String addBinaryLarge(String A, String B) {
        if (A.length() > B.length()) {
            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < A.length() - B.length(); i++) pad.append('0');
            B = pad.toString() + B;
        } else if (A.length() < B.length()){
            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < B.length() - A.length(); i++) pad.append('0');
            A = pad.toString() + A;
        }
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = A.length() -1; i >= 0; i--) {
            int x = (((A.charAt(i) - 48) + (B.charAt(i) - 48))) + carry;
            if (x >= 2) carry = 1;
            else carry = 0;
            int mod = x % 2;
            sb.append(Integer.toString(mod));
        } if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
