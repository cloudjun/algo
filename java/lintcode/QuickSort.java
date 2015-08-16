package lintcode;

/**
 * Created by jun on 8/13/2015.
 */
public class QuickSort {
    private void swap(int[] A, int pos1, int pos2) {
        int temp = A[pos1];
        A[pos1] = A[pos2];
        A[pos2] = temp;
    }

    private int partition(int[] A, int start, int end) {
        if (start > end) {
            return -1;
        }

        // Let's say we pick the very first element to be the pivot.
        int index = start;
        swap(A, index, end); // Move the pivot to the end.

        // Move all elements less than(equal to) the pivot to the left most
        for (int i = start; i < end; i++) {
            if (A[i] <= A[end]) {
                if (i != start) {
                    swap(A, i, start);
                }
                index++;
            }
        }

        // Move the pivot to the right place
        swap(A, index, end);
        return index;
    }

    public void quickSort(int[] A, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int index = partition(A, lo, hi);
        quickSort(A, lo, index - 1);
        quickSort(A, index + 1, hi);
    }

    public void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
}
