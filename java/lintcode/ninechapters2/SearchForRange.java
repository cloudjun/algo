package lintcode.ninechapters2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jun on 7/18/2015.
 */
public class SearchForRange {
    /**
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        if (A == null || A.size() == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(-1);
            result.add(-1);
            return result;
        }
        
        int[] nums = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            nums[i] = A.get(i).intValue();
        }
        int[] result = searchRange(nums, target);
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            resultList.add(result[i]);
        }
        return resultList;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int pos = 0, returnStart = 0;
        if (nums[start] == target) {
            pos = start;
        } else if (nums[end] == target) {
            pos = end;
        } else { // target not found
            return new int[] {-1, -1};
        }

        returnStart = pos;
        while (pos + 1 < nums.length && nums[pos] == nums[pos + 1]) {
            pos++;
        }
        return new int[] {returnStart, pos};
    }
}
