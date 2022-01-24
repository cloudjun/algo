# Given an integer array elements, return the length of the longest strictly
# increasing subsequence. 
# 
#  A subsequence is a sequence that can be derived from an array by deleting 
# some or no elements without changing the order of the remaining elements. For 
# example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 
# 
#  
#  Example 1: 
# 
#  
# Input: elements = [10,9,2,5,3,7,101,18]
# Output: 4
# Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
# length is 4.
#  
# 
#  Example 2: 
# 
#  
# Input: elements = [0,1,0,3,2,3]
# Output: 4
#  
# 
#  Example 3: 
# 
#  
# Input: elements = [7,7,7,7,7,7,7]
# Output: 1
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= elements.length <= 2500
#  -10⁴ <= elements[i] <= 10⁴
#  
# 
#  
#  Follow up: Can you come up with an algorithm that runs in O(n log(n)) time 
# complexity? 
#  Related Topics Array Binary Search Dynamic Programming 👍 10038 👎 203


# leetcode submit region begin(Prohibit modification and deletion)
def binary_search(elements, target):
    start, end = 0, len(elements) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if elements[mid] < target:
            start = mid
        else:
            end = mid
    if elements[start] >= target:
        return start
    if elements[end] >= target:
        return end
    return -1


class Solution(object):
    # DP: O(n^2)
    # def lengthOfLIS(self, elements):
    #     """
    #     :type elements: List[int]
    #     :rtype: int
    #     """
    #     if elements is None:
    #         return 0
    # 
    #     size = len(elements)
    #     result = 1
    #     dp = [1] * size
    #     for i in range(1, size):
    #         for j in range(0, i):
    #             if elements[i] > elements[j]:
    #                 dp[i] = max(dp[i], dp[j] + 1)
    #                 result = max(result, dp[i])
    #     return result

    # binary search: O(nlog(n))
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1

        result = [nums[0]]
        for i in range(1, len(nums)):
            # print(result)
            num = nums[i]
            if num > result[-1]:
                result.append(num)
            # elif num == result[-1]:
            #     continue
            else:
                index = binary_search(result, num)
                if index != -1:
                    result[index] = num
        return len(result)


# leetcode submit region end(Prohibit modification and deletion)

print(Solution().lengthOfLIS([1, 3, 6, 7, 9, 4, 10, 5, 6]))