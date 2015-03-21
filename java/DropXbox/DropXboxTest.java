package DropXbox;

import org.junit.Assert;
import org.junit.Test;

public class DropXboxTest {
    @Test
    public void testDrop() {
        DropXbox drop = new DropXbox();

        // With enough xboxes to drop, we can always use binary search.
        // 2^5 < 63 < 2^6, so for 63 stories we can drop 6 times, and for 64 stories we can find it for 7 times.
        int number = drop.start(99, 63);
        Assert.assertEquals(6, number);
        number = drop.start(99, 64);
        Assert.assertEquals(7, number);

        // For 2 xboxes and 100 stories we should start from 14th floor
        number = drop.start(2, 100);
        Assert.assertEquals(14, number);

        // For 2 xboxes and 120 stories we should start from 15th floor
        number = drop.start(2, 120);
        Assert.assertEquals(15, number);
    }
}