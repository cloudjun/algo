package lintcode.ninechapters1.level01;

import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by jun on 6/30/2015.
 */
public class StrstrTest {

    @org.junit.Test
    public void testStrStr() throws Exception {
        Strstr strstr = new Strstr();
        String source = "abcd";
        String target = "abcd";

        Assert.assertEquals(0, strstr.strStr(source, target));

        target = "abcdefg";
        Assert.assertEquals(-1, strstr.strStr(source, target));

        target = "cd";
        Assert.assertEquals(2, strstr.strStr(source, target));

        target = "cde";
        Assert.assertEquals(-1, strstr.strStr(source, target));
    }
}