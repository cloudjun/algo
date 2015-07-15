package lintcode.ninechapters2;

import java.util.ArrayList;

/**
 * Created by jun on 7/15/2015.
 */
public class RecoverRotatedSortedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() < 2) {
            return;
        }

        int index = 0;
        for (int i = 1; i < nums.size(); i++) {
            index = i;
            if (nums.get(i) < nums.get(i - 1)) {
                break;
            }
        }

        if (index == nums.size() - 1) {
            return;
        }

        swap(nums, 0, index - 1);
        swap(nums, index, nums.size() - 1);
        swap(nums, 0, nums.size() - 1);
    }

    private void swap(ArrayList<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }

        Integer temp;
        while (start < end) {
            temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
