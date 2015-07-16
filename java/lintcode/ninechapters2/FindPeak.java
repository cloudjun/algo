package lintcode.ninechapters2;

/**
 * Created by jun on 7/15/2015.
 */
public class FindPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
                end = mid;
            } else if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
                end = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
