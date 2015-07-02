package lintcode.ninechapters1.level01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jun on 7/2/2015.
 */
public class Permutations2 {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.size()];
        Integer[] input = nums.toArray(new Integer[0]);
        Arrays.sort(input); // has to be sorted
        helper(input, result, list, visited);
        return result;
    }

    private void helper(Integer[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // i > 0 so that i - 1 will not out of range
            // 前面一个元素没有被访问过
            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
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
