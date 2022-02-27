//Given an array of integers nums, sort the array in ascending order. 
//
// 
// Example 1: 
// Input: nums = [5,2,3,1]
//Output: [1,2,3,5]
// Example 2: 
// Input: nums = [5,1,1,2,0,0]
//Output: [0,0,1,1,2,5]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Merge 
//Sort Bucket Sort Radix Sort Counting Sort 👍 1714 👎 477

import java.util.Arrays;
import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 5, 1, 2, 3, 1 };
        new Solution().quick(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public int[] sortArray(int[] nums) {
        quick(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public void quick(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition_wall(nums, left, right);
        quick(nums, left, pivot - 1);
        quick(nums, pivot + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int start = left, end = right - 1;
        int pivot = nums[right];
        while (start <= end) {
            if (nums[start] <= pivot) start++;
            else if (nums[end] > pivot) end--;
            else swap(nums, start++, end--);
        }
        swap(nums, start, right);
        return start;
    }

    private int partition_wall(int[] nums, int left, int right) {
        // randomization pivot
        int rand = left + new Random().nextInt(right - left);
        swap(nums, rand, right);

        int pivot = nums[right], wall = left;
        for (int i = left; i < right; i++) {
           if (nums[i] < pivot)  {
               swap(nums, i, wall);
               wall++;
           }
        }
        swap(nums, wall, right);
        return wall;
    }

    /* jiuzhang
    private int[] partition_jiuzhang(int[] nums, int left, int right) {
        int start = left, end = right;
//        int pivot = nums[(end - start) / 2 + start];
        int pivot = nums[new Random().nextInt(end - start + 1) + start];
        while (start <= end) {
            if (nums[start] < pivot) start++;
            else swap(nums, start++, end--);
        }
        return new int[] {start, end};
    }

    public void quick_jiuzhang(int[] nums, int left, int right) {
        if (left >= right) return;
        int[] positions = partition_jiuzhang(nums, left, right);
        quick_jiuzhang(nums, left, positions[1]);
        quick_jiuzhang(nums, positions[0], right);
    }
    */
}
//leetcode submit region end(Prohibit modification and deletion)
