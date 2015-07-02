package lintcode.ninechapters1.level01;

import lintcode.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jun on 7/2/2015.
 */
public class Permutations2Test {

    @Test
    public void testPermuteUnique() throws Exception {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4));
        Permutations2 p = new Permutations2();
        Util.print(p.permuteUnique(input));
    }
}