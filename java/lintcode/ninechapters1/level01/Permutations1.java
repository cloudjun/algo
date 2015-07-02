package lintcode.ninechapters1.level01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jun on 7/2/2015.
 */
public class Permutations1 {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.size()];
        Integer[] input = nums.toArray(new Integer[0]);
//        Arrays.sort(input);
        helper(input, result, list, visited);
        return result;
    }

    private void helper(Integer[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
              continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(nums, result, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
