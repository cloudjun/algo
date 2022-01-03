# Given an array of integers elements and an integer target, return indices of the
# two numbers such that they add up to target. 
# 
#  You may assume that each input would have exactly one solution, and you may 
# not use the same element twice. 
# 
#  You can return the answer in any order. 
# 
#  
#  Example 1: 
# 
#  
# Input: elements = [2,7,11,15], target = 9
# Output: [0,1]
# Output: Because elements[0] + elements[1] == 9, we return [0, 1].
#  
# 
#  Example 2: 
# 
#  
# Input: elements = [3,2,4], target = 6
# Output: [1,2]
#  
# 
#  Example 3: 
# 
#  
# Input: elements = [3,3], target = 6
# Output: [0,1]
#  
# 
#  
#  Constraints: 
# 
#  
#  2 <= elements.length <= 10⁴
#  -10⁹ <= elements[i] <= 10⁹
#  -10⁹ <= target <= 10⁹ 
#  Only one valid answer exists. 
#  
# 
#  
# Follow-up: Can you come up with an algorithm that is less than O(n²) time 
# complexity? Related Topics Array Hash Table 👍 27293 👎 875


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        num_dict = {}
        for i in range(len(nums)):
            num = nums[i]
            target_num = target - num
            # print("num={}, targetNum={}, numDict={}".format(num, target_num, num_dict))
            if target_num in num_dict:
                return [num_dict[target_num], i]
            num_dict[num] = i
        return [-1, -1]
# leetcode submit region end(Prohibit modification and deletion)

print(Solution().twoSum([2,7,11,15], 9))