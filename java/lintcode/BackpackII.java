package lintcode;

/**
 * Created by jun on 8/16/2015.
 */
public class BackpackII {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // Let f[i][s] be the max value when you put i items in the backpack with total size of s.
        // f[i][s] = max(f[i - 1][s], f[i - 1][s - A[i]] + V[i])
        // f[0][0] = 0; f[x][0] = 0; f[0][x] = 0;
        // answer: f[A.length][m]

        if (A == null || V == null) {
            return 0;
        }

        if (A.length == 0 || V.length == 0 || A.length != V.length) {
            return 0;
        }

        int len = A.length;
        int[][] f = new int[len + 1][m + 1];
        for (int i = 0; i <= len; i++) {
            f[i][0] = 0;
            f[0][i] = 0;
        }

        // i needs to start from 1, so that i-1 can start from 0;
        for (int i = 1; i <= len; i++) {
            for (int s = 0; s <= m; s++) {
                if (s >= A[i - 1]) {
                    f[i][s] = Math.max(f[i - 1][s], f[i - 1][s - A[i - 1]] + V[i - 1]);
                } else {
                    // Not picking i
                    f[i][s] = f[i - 1][s];
                }
            }
        }

        for (int i = m; i > 0; i++) {
            if (f[len][i] != 0) {
                return f[len][i];
            }
        }

        return 0;
    }
}
