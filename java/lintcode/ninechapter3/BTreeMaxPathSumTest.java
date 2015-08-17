package lintcode.ninechapter3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jun on 8/16/2015.
 */
public class BTreeMaxPathSumTest {

    @Test
    public void testMaxPathSum() throws Exception {
        TreeNode root = new TreeNode(-1);
        int sum = new BTreeMaxPathSum().maxPathSum(root);
        Assert.assertEquals(-1, sum);
    }
}