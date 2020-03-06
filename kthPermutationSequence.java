public class kthPermutationSequence {
    public static String result = new String();
    public static boolean visit[] = new boolean[1000];
    public static long[] permutation = new long[20];

    public static void dfs(int index, int dep, long sum, int N, int target) {
        if (dep > N) return ;
        if (dep == N && target == sum) {
            return;
        }
        for (int i = index; i <= N; i++) {
            if (visit[i] == false) {
                if (target > sum + permutation[N - dep - 1]) {
                    dfs(i + 1, dep, sum + permutation[N - dep - 1], N, target);
                } else {
                    visit[i] = true;
                    result += Integer.toString(i);
                    dfs(1,dep + 1, sum, N, target);
                }
            }
        }
    }

    public static String getPermutation(int A, int B) {
        permutation[0] = 1;
        for (int i = 1; i <= A; i++) permutation[i] = permutation[i-1] * i;
        for (int i = 0; i <= A; i++) visit[i] = false;
        dfs(1, 0, 0, A, B);
        return result;
    }

    public static void main(String args[]) {
        getPermutation(11, 1000000000);
        System.out.println(result);
    }
}
