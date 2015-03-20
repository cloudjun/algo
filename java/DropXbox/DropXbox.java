package DropXbox;

import java.lang.Integer;

public class DropXbox {
    public static void main(String[] args) {
        int n = 2, k = 120;
        System.out.println(dropXbox(n, k));
    }

    public static int dropXbox(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        if (k == 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= k; x++) {
            min = Math.min(min, Math.max(dropXbox(n - 1, x - 1), dropXbox(n, k - x)));
        }
        return min + 1;
    }
}