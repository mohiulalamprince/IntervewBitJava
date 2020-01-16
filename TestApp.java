import java.util.ArrayList;
import java.util.Arrays;

interface FuncInterface
{
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun() {
        System.out.println("Hello");
    }
}

public class TestApp {
    public static void main(String args[]) {
        System.out.println("hello world");

        FuncInterface fobj = (int x)->System.out.println(2*x);
        fobj.abstractFun(5);
        fobj.normalFun();

        ArrayList<Integer> arrayList = new ArrayList<>(5);


        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(4, 0, 2, 1, 3));
        ArrayList<Long> a = new ArrayList<Long>();
        for (int i = 0; i < b.size(); i++) {
            a.add(b.get(i).longValue());
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) << 32);
        }
        a.forEach(n -> System.out.println(n));

        for (int i = 0; i < a.size(); i++) {
            Long originalValue = a.get(i) >> 32;
            Long indexValue = a.get(originalValue.intValue()) >> 32;
            a.set(i, a.get(i) | indexValue);
        }

        for (int i = 0; i < a.size(); i++) {
            a.set(i, (a.get(i) << 32) >> 32);
        }
        a.forEach(n -> System.out.println(n));

        String s = "AB";
        Long sum = 0l;
        Long mul = 1l;
        for (int i = s.length()-1; i >= 0; i --) {
            System.out.println(s.charAt(i) - 64);
            sum += ((s.charAt(i) - 64) * mul);
            mul *= 26;
        }
        System.out.println(sum);

        int range[] = new int[10];
        for (int i = 0; i < range.length; i++) {
            range[i] = 26 * (i + 1);
        }
    }
}
