package lintcode.ninechapters1.level01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jun on 7/2/2015.
 */
public class Subsets2 {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        if (S == null || S.size() == 0) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] input = S.toArray(new Integer[0]);
        Arrays.sort(input);
        helper(new ArrayList<>(Arrays.asList(input)), result, list, 0);
        return result;
    }

    private void helper(ArrayList<Integer> s, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < s.size(); i++) {
            if (i != pos && s.get(i) == s.get(i - 1)) {
                continue;
            }
            list.add(s.get(i));
            helper(s, result, list, i + 1);
//            list.remove(s.get(i));
            list.remove(list.size() - 1);
        }
    }
}
