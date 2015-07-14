package lintcode.ninechapters2;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jun on 7/14/2015.
 */
public class MergeSortedArrayTest {

    @Test
    public void testMergeSortedArray() throws Exception {
        int[] A = new int[5];
        A[0] = 1; A[1] = 2; A[2] = 3;
        int[] B = {4, 5};

        new MergeSortedArray().mergeSortedArray(A, 3, B, 2);
        Arrays.stream(A).forEach(i -> System.out.print(i + ","));
    }
}