package DropXbox;

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class DropXbox {
    int[][] values; // cached values for each n, k combination
    int firstDropFloor = -1;
    int[] floor;

    public int getFirstDropFloor() {
        return firstDropFloor;
    }

    public int start(int n, int k) {
        values = new int[n][k];
        floor = new int[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                values[i][j] = -1;
            }
        }

        for (int i = 0; i < k; i++) {
            floor[i] = 0;
        }

        int result = dropXbox(n, k);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < k; j++) {
//                System.out.print(values[i][j] + ",");
//            }
//            System.out.println("");
//        }
        for (int i = 0; i < k; i++) {
            System.out.print(floor[i] + ",");
        }
        return result;
    }

    private int dropXbox(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        if (n == 1) {
            return k;
        }

        if (k == 1) {
            return 1;
        }

        if (values[n - 1][k - 1] != -1) {
            return values[n - 1][k - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= k; x++) {
            int xFloorMax = Math.max(dropXbox(n - 1, x - 1), dropXbox(n, k - x));
            int temp = Math.min(min, xFloorMax);
            floor[x - 1] = xFloorMax;
            if (temp != min) {
                firstDropFloor = x;
                min = temp;
            }
        }

        values[n - 1][k - 1] = min + 1;
        return values[n - 1][k - 1];
    }
}