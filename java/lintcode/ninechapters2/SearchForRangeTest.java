package lintcode.ninechapters2;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jun on 7/18/2015.
 */
public class SearchForRangeTest {

    @Test
    public void testSearchRange() throws Exception {
        int[] input = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] result = new SearchForRange().searchRange(input, 5);
        Assert.assertEquals(0, result[0]);
        Assert.assertEquals(9, result[1]);
    }
}