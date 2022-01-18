# Given an integer array nums that may contain duplicates, return all possible 
# subsets (the power set). 
# 
#  The solution set must not contain duplicate subsets. Return the solution in 
# any order. 
# 
#  
#  Example 1: 
#  Input: nums = [1,2,2]
# Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
#  Example 2: 
#  Input: nums = [0]
# Output: [[],[0]]
#  
#  
#  Constraints: 
# 
#  
#  1 <= nums.length <= 10 
#  -10 <= nums[i] <= 10 
#  
#  Related Topics Array Backtracking Bit Manipulation 👍 4137 👎 134


# leetcode submit region begin(Prohibit modification and deletion)
import copy


class Solution(object):
    def helper(self, result, current_subset, nums, pos):
        result.append(copy.deepcopy(current_subset))
        for i in range(pos, len(nums)):
            # dedup
            if i != pos and nums[i] == nums[i - 1]:
                continue
            current_subset.append(nums[i])
            self.helper(result, current_subset, nums, i + 1)
            current_subset.pop()

    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = list(list())
        current_subset = list()
        nums.sort()
        self.helper(result, current_subset, nums, 0)
        return result

# leetcode submit region end(Prohibit modification and deletion)
