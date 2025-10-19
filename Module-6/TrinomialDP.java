// Test Cases
// 3 0 :: 7
// 24 12 :: 287134346
// 30 0 :: 18252025766941
// 40 0 :: 934837217271732457
public class TrinomialDP {
    public static long trinomial(int n, int k) {
   // performance improvement over recursive calling
        k = Math.abs(k);
        long[][] aT = new long[n + 2][k + n + 1];
        aT[0][0] = 1;
        aT[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k + (n - i); j++) {
                if (j > i) { aT[i][j] = 0; }
                aT[i][j] = aT[i - 1][Math.abs(j - 1)] + aT[i - 1][j] + aT[i - 1][j + 1];
            }
        }
        return aT[n][k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        long t = trinomial(n, k);
        StdOut.println(t);
    }
}
