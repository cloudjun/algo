package lintcode.ninechapters1.level01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by jun on 7/1/2015.
 *
 * Given a set of distinct integers, return all possible subsets.
 */
public class Subsets1 {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        if (S == null || S.size() == 0) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
//        S.sort((o1, o2) -> o1 < o2 ? -1 : o1 == o2 ? 0 : 1);
        Integer[] input = (Integer[]) S.toArray(new Integer[0]);
        Arrays.sort(input);
        helper(new ArrayList<Integer>(Arrays.asList(input)), result, list, 0);
        return result;
    }

    private void helper(ArrayList<Integer> s, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < s.size(); i++) {
            list.add(s.get(i));
            helper(s, result, list, i + 1);
            list.remove(s.get(i));
        }
    }
}
