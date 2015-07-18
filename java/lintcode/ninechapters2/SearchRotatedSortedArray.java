package lintcode.ninechapters2;

/**
 * Created by jun on 7/18/2015.
 */
public class SearchRotatedSortedArray {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search_dummy_way(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        if (target == A[0]) {
            return 0;
        }

        if (target == A[A.length - 1]) {
            return A.length - 1;
        }

        if (A.length == 1) {
            return -1;
        }

        int startValue = A[0];
        int endValue = A[A.length - 1];
        int start = 0, end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target >= startValue) {
                if (A[mid] >= startValue) {
                    if (target < A[mid]) {
                        end = mid;
                    } else if (target > A[mid]) {
                        start = mid;
                    } else {
                        return mid;
                    }
                } else { // A[mid] <= endValue
                    end = mid;
                }
            } else { // target <= endValue
                if (A[mid] <= endValue) {
                    if (target > A[mid]) {
                        start = mid;
                    } else if (target < A[mid]) {
                        end = mid;
                    } else {
                        return mid;
                    }
                } else { // A[mid] >= startValue
                    start = mid;
                }
            }
        }

        if (target == A[start]) {
            return start;
        } else if (target == A[end]) {
            return end;
        } else {
            return -1;
        }
    }
}
