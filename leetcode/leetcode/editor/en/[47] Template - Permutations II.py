# Given a collection of numbers, nums, that might contain duplicates, return 
# all possible unique permutations in any order. 
# 
#  
#  Example 1: 
# 
#  
# Input: nums = [1,1,2]
# Output:
# [[1,1,2],
#  [1,2,1],
#  [2,1,1]]
#  
# 
#  Example 2: 
# 
#  
# Input: nums = [1,2,3]
# Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= nums.length <= 8 
#  -10 <= nums[i] <= 10 
#  
#  Related Topics Array Backtracking 👍 4273 👎 88


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def helper(self, result, current, nums, visited: list[bool]):
        if len(current) == len(nums):
            result.append(current[:])
            return
        for i in range(len(nums)):
            if visited[i] or (i > 0 and nums[i] == nums[i - 1] and visited[i - 1]):
                continue
            visited[i] = True
            current.append(nums[i])
            self.helper(result, current, nums, visited)
            current.pop()
            visited[i] = False


    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        result = []
        current = []
        visited = [False] * len(nums)
        self.helper(result, current, nums, visited)
        return result
# leetcode submit region end(Prohibit modification and deletion)

print(Solution().permuteUnique([1, 1, 2]))