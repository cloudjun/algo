package TestQuestions;

import org.junit.Assert;
import org.junit.Test;

public class ItoATest {
    @Test
    public void testZero() {
        ItoA test = new ItoA();
        String s = test.iToA(0, 8);
        Assert.assertEquals("0", s);
        s = test.iToA(0, 10);
        Assert.assertEquals("0", s);
        s = test.iToA(0, 16);
        Assert.assertEquals("0", s);
    }

    @Test
    public void testInvalidBase() {
        ItoA test = new ItoA();
        String s = test.iToA(24, 123);
        Assert.assertEquals(null, s);
    }

    @Test
    public void testOctal() {
        ItoA test = new ItoA();
        String s = test.iToA(-1234567, 8);
        Assert.assertEquals("-4553207", s);
    }

    @Test
    public void testDecimal() {
        ItoA test = new ItoA();
        String s = test.iToA(1234567, 10);
        Assert.assertEquals("1234567", s);
    }

    @Test
    public void testHex() {
        ItoA test = new ItoA();
        String s = test.iToA(1234567, 16);
        Assert.assertEquals("12D687", s);
    }
}