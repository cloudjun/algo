package TestQuestions;

import org.junit.Assert;
import org.junit.Test;

public class MatrixOrderTest {
    @Test
    public void testMatrixNull() {
        int[][] matrix = new int[][] {
                {}
        };
        int[] result = new MatrixOrder().walk(matrix);
        Assert.assertEquals(null, result);

        matrix = null;
        result = new MatrixOrder().walk(matrix);
        Assert.assertEquals(null, result);

        matrix = new int[][] {
                {},
                {},
                {}
        };
        result = new MatrixOrder().walk(matrix);
        Assert.assertEquals(null, result);

        matrix = new int[][] {};
        result = new MatrixOrder().walk(matrix);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testMatrixInvalid() {
        int[][] matrix = new int[][] {
                {2,3,4,8},
                {5,7,9,12,22,99,101},
                {1,0,6,10}
        };
        int[] result = new MatrixOrder().walk(matrix);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testMatrix() {
        int[][] matrix = new int[][] {
                {2,3,4,8},
                {5,7,9,12},
                {1,0,6,10}
        };
        int[] result = new MatrixOrder().walk(matrix);
        StringBuilder sb = new StringBuilder();
        for (int aResult : result) {
            sb.append(aResult).append(",");
        }
        Assert.assertEquals("2,3,4,8,12,10,6,0,1,5,7,9,", sb.toString());
    }

    @Test
    public void testMatrixOneLiner() {
        int[][] matrix = new int[][] {
                {2,3,4,8}
        };
        int[] result = new MatrixOrder().walk(matrix);
        StringBuilder sb = new StringBuilder();
        for (int aResult : result) {
            sb.append(aResult).append(",");
        }
        Assert.assertEquals("2,3,4,8,", sb.toString());
    }

    @Test
    public void testMatrixVertical() {
        int[][] matrix = new int[][] {
                {2},
                {5},
                {1}
        };
        int[] result = new MatrixOrder().walk(matrix);
        StringBuilder sb = new StringBuilder();
        for (int aResult : result) {
            sb.append(aResult).append(",");
        }
        Assert.assertEquals("2,5,1,", sb.toString());
    }

    @Test
    public void testMatrixLarge() {
        int[][] matrix = new int[][] {
                {1,2,3,4,5,6,7,8,9,10},
                {24,25,26,27,28,29,30,31,32,11},
                {23,40,39,38,37,36,35,34,33,12},
                {22,21,20,19,18,17,16,15,14,13}
        };
        int[] result = new MatrixOrder().walk(matrix);
        StringBuilder sb = new StringBuilder();
        for (int aResult : result) {
            sb.append(aResult).append(",");
        }
        Assert.assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,", sb.toString());
    }
}