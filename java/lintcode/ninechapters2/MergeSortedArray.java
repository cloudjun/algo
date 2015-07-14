package lintcode.ninechapters2;

/**
 * Created by jun on 7/14/2015.
 */
public class MergeSortedArray {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if ((m < 0 && n < 0) || (m == 0 && n == 0)) {
            return;
        }

        if (m == 0) {
            for (int i = n - 1; i >= 0; i--) {
                A[i] = B[i];
            }
            return;
        }

        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[i + j + 1] = A[i];
                i--;
            } else {
                A[i + j + 1] = B[j];
                j--;
            }
        }
        if (i < 0) {
            while (j >= 0) {
                A[j] = B[j];
                j--;
            }
        }
    }
}
