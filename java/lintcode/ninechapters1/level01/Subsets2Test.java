package lintcode.ninechapters1.level01;

import lintcode.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jun on 7/2/2015.
 */
public class Subsets2Test {

    @Test
    public void testSubsetsWithDup() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        Subsets2 s2 = new Subsets2();
        Util.print(s2.subsetsWithDup(input));

        input = new ArrayList<>(Arrays.asList());
        s2 = new Subsets2();
        Util.print(s2.subsetsWithDup(input));

        input = new ArrayList<>(Arrays.asList(23));
        s2 = new Subsets2();
        Util.print(s2.subsetsWithDup(input));

        input = new ArrayList<>(Arrays.asList(4, 1, 1, 0));
        s2 = new Subsets2();
        Util.print(s2.subsetsWithDup(input));
    }
}