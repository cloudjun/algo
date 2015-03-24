package TestQuestions;

import org.junit.Assert;
import org.junit.Test;

public class DropXboxTest {
    @Test
    public void testDrop() {
        DropXbox drop = new DropXbox();

        // test edge cases
        int number = drop.start(-1, -9);
        Assert.assertEquals(0, number);

        number = drop.start(0, 0);
        Assert.assertEquals(0, number);

        number = drop.start(0, 18);
        Assert.assertEquals(0, number);

        number = drop.start(22, 0);
        Assert.assertEquals(0, number);

        // one xbox
        number = drop.start(1, 34);
        Assert.assertEquals(34, number);

        // one floor
        number = drop.start(22, 1);
        Assert.assertEquals(1, number);

        // With enough xboxes to drop, we can always use binary search.
        // 2^5 < 63 < 2^6, so for 63 stories we can drop 6 times, and for 64 stories we can find it for 7 times.
        number = drop.start(99, 63);
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