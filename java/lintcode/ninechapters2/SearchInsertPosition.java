package lintcode.ninechapters2;

/**
 * Created by jun on 7/14/2015.
 */
public class SearchInsertPosition {
    /**
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target <=A[start]) {
            return start == 0 ? 0 : start - 1;
        } else if (target <= A[end]) {
            return start + 1;
        } else {
            return end + 1;
        }
    }
}
