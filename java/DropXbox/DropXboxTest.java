package DropXbox;

import org.junit.Assert;
import org.junit.Test;

public class DropXboxTest {
    @Test
    public void testDrop() {
        DropXbox drop = new DropXbox();
        int number = drop.start(10, 60);
        Assert.assertEquals(14, number);
    }
}