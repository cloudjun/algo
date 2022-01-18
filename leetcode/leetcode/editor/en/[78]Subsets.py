# Given an integer array nums of unique elements, return all possible subsets (
# the power set). 
# 
#  The solution set must not contain duplicate subsets. Return the solution in 
# any order. 
# 
#  
#  Example 1: 
# 
#  
# Input: nums = [1,2,3]
# Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
#  
# 
#  Example 2: 
# 
#  
# Input: nums = [0]
# Output: [[],[0]]
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= nums.length <= 10 
#  -10 <= nums[i] <= 10 
#  All the numbers of nums are unique. 
#  
#  Related Topics Array Backtracking Bit Manipulation 👍 7964 👎 133


# leetcode submit region begin(Prohibit modification and deletion)
import copy


class Solution:
    # backtracking
    # def helper(self, result, current_subset, nums, pos):
    #     result.append(copy.deepcopy(current_subset))
    #     for i in range(pos, len(nums)):
    #         current_subset.append(nums[i])
    #         self.helper(result, current_subset, nums, i + 1)
    #         current_subset.pop()
    #
    # def subsets(self, nums):
    #     """
    #     :type nums: List[int]
    #     :rtype: List[List[int]]
    #     """
    #     result = list(list())
    #     current_subset = list()
    #     self.helper(result, current_subset, nums, 0)
    #     return result

    # cascading
    # def subsets(self, nums):
    #     subsets = [[]]
    #     for n in nums:
    #         subsets += [s + [n] for s in subsets]
    #     return subsets

    # bitmask
    def subsets(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        output = []

        for i in range(2 ** n, 2 ** (n + 1)):
            # generate bitmask, from 0..00 to 1..11
            bitmask = bin(i)[3:]

            # append subset corresponding to that bitmask
            output.append([nums[j] for j in range(n) if bitmask[j] == '1'])

        return output


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().subsets([1, 2, 3]))
