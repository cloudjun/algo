# Given an array nums which consists of non-negative integers and an integer m, 
# you can split the array into m non-empty continuous subarrays. 
# 
#  Write an algorithm to minimize the largest sum among these m subarrays. 
# 
#  
#  Example 1: 
# 
#  
# Input: nums = [7,2,5,10,8], m = 2
# Output: 18
# Explanation:
# There are four ways to split nums into two subarrays.
# The best way is to split it into [7,2,5] and [10,8],
# where the largest sum among the two subarrays is only 18.
#  
# 
#  Example 2: 
# 
#  
# Input: nums = [1,2,3,4,5], m = 2
# Output: 9
#  
# 
#  Example 3: 
# 
#  
# Input: nums = [1,4,4], m = 3
# Output: 4
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= nums.length <= 1000 
#  0 <= nums[i] <= 10⁶ 
#  1 <= m <= min(50, nums.length) 
#  
#  Related Topics Array Binary Search Dynamic Programming Greedy 👍 4133 👎 124


# leetcode submit region begin(Prohibit modification and deletion)
import sys


class Solution(object):
    # def splitArray(self, nums, m):
    #     """
    #     :type nums: List[int]
    #     :type m: int
    #     :rtype: int
    #     """
    #     size = len(nums)
    #     # dp[i][j]:
    #     #   i - how many subarrays
    #     #   j - total length of the array
    #     dp = [[sys.maxsize] * size for _ in range(m + 1)]
    #     sums = [0] * size
    #     sums[0] = nums[0]
    #     for i in range(1, size):
    #         sums[i] = sums[i - 1] + nums[i]
    #     for i in range(size):
    #         dp[1][i] = sums[i]
    #     for i in range(2, m + 1):
    #         # print('i={}'.format(i))
    #         # j's range needs to start from i-1 (or just 0) for the case when m==size, else
    #         # the j loop will skip m==size
    #         for j in range(i - 1, size):
    #             # print('  j={}'.format(j))
    #             for k in range(j):
    #                 dp[i][j] = min(dp[i][j], max(dp[i - 1][k], sums[j] - sums[k]))
    #                 # print('    dp[{}][{}]={}'.format(i, j, dp[i][j]))
    #     return dp[m][size - 1]

    # binary search
    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        start = max(num for num in nums)
        end = sum(num for num in nums)
        while start + 1 < end:
            mid = (start + end) // 2
            if self.is_valid_groups(nums, m, mid):
                end = mid
            else:
                start = mid
        is_start_valid = self.is_valid_groups(nums, m, start)
        is_end_valid = self.is_valid_groups(nums, m, end)
        if is_start_valid and not is_end_valid:
            return start
        elif not is_start_valid:
            return end
        else:
            return start

    def is_valid_groups(self, nums, m, target_value):
        sum, count = 0, 1
        for i in range(len(nums)):
            sum += nums[i]
            if sum > target_value:
                sum = nums[i]
                count += 1
        return count <= m


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().splitArray([7, 2, 5, 10, 8], 2))
# print(Solution().splitArray([1, 4, 4], 3))
