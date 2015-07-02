package lintcode.ninechapters1.level01;

import lintcode.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jun on 7/1/2015.
 */
public class Subsets1Test {

    @Test
    public void testSubsets() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        Subsets1 s1 = new Subsets1();
        Util.print(s1.subsets(input));

        input = new ArrayList<>(Arrays.asList());
        s1 = new Subsets1();
        Util.print(s1.subsets(input));

        input = new ArrayList<>(Arrays.asList(23));
        s1 = new Subsets1();
        Util.print(s1.subsets(input));

        input = new ArrayList<>(Arrays.asList(4, 1, 0));
        s1 = new Subsets1();
        Util.print(s1.subsets(input));
    }
}