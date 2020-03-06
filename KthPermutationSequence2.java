import java.util.ArrayList;

public class KthPermutationSequence2 {
    public static void main(String args[]) {
        System.out.println(getPermutation(12, 1000000000));
    }
    public static String getPermutation(int A, int B) {
        ArrayList<String> a = new ArrayList<String>();
        for(int i=1; i<=A; i++){
            a.add(Integer.toString(i));

        }
        ArrayList<String> ans = new ArrayList<String>();
        helper(A, B, 0, a, new ArrayList<String>(), ans);
        return ans.get(0);
    }

    private static int helper(int n, int k, int count, ArrayList<String> a, ArrayList<String> curr, ArrayList<String> ans) {
        if(curr.size() == n) {
            return ++count;
        }

        for(int i=0; i<a.size(); i++){
            String v = a.get(i);
            curr.add(v);
            a.remove(i);
            count = helper(n, k, count, a, curr, ans);
            if( count== k) {
                StringBuilder sb = new StringBuilder();
                for(String s: curr) {
                    sb.append(s);

                }
                if(ans.size() > 1)
                    ans.set(0,sb.toString());
                else
                    ans.add(sb.toString());
                return k;

            }
            a.add(i, v);
            curr.remove(curr.size()-1);

        }
        return count;
    }
}

