package TestQuestions;

public class DropXbox {
    int[][] values; // cached values for each n, k combination

    public int start(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }
        // initialize cache
        values = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                values[i][j] = -1;
            }
        }
        return dropXbox(n, k);
    }

    /**
     * @param n number of xboxes
     * @param k number of stories
     * @return the min number for the drops for a given n and k combination
     */
    private int dropXbox(int n, int k) {
        // n<=0 or k<=0 doesn't have any physical meaning. Return 0.
        if (n <= 0 || k <= 0) {
            return 0;
        }

        // Given one xbox, worst case is always drop k floors.
        if (n == 1) {
            return k;
        }

        // One story building means we only need to test once.
        if (k == 1) {
            return 1;
        }

        if (values[n - 1][k - 1] != -1) {
            return values[n - 1][k - 1];
        }

        // Please refer to README.md for the explanation.
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= k; x++) {
            min = Math.min(min, Math.max(dropXbox(n - 1, x - 1), dropXbox(n, k - x)));
        }

        values[n - 1][k - 1] = min + 1;
        return values[n - 1][k - 1];
    }
}