# You have a lock in front of you with 4 circular wheels. Each wheel has 10 
# slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
# freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
# Each move consists of turning one wheel one slot. 
# 
#  The lock initially starts at '0000', a string representing the state of the 4
#  wheels. 
# 
#  You are given a list of deadends dead ends, meaning if the lock displays any 
# of these codes, the wheels of the lock will stop turning and you will be unable 
# to open it. 
# 
#  Given a target representing the value of the wheels that will unlock the 
# lock, return the minimum total number of turns required to open the lock, or -1 if 
# it is impossible. 
# 
#  
#  Example 1: 
# 
#  
# Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
# Output: 6
# Explanation: 
# A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
# 01" -> "1202" -> "0202".
# Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
# would be invalid,
# because the wheels of the lock become stuck after the display becomes the 
# dead end "0102".
#  
# 
#  Example 2: 
# 
#  
# Input: deadends = ["8888"], target = "0009"
# Output: 1
# Explanation: We can turn the last wheel in reverse to move from "0000" -> "000
# 9".
#  
# 
#  Example 3: 
# 
#  
# Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
# target = "8888"
# Output: -1
# Explanation: We cannot reach the target without getting stuck.
#  
# 
#  
#  Constraints: 
# 
#  
#  1 <= deadends.length <= 500 
#  deadends[i].length == 4 
#  target.length == 4 
#  target will not be in the list deadends. 
#  target and deadends[i] consist of digits only. 
#  
#  Related Topics Array Hash Table String Breadth-First Search 👍 2442 👎 85


# leetcode submit region begin(Prohibit modification and deletion)
from collections import deque


class Solution(object):
    # def get_next_states(self, num_str):
    #     next_states = []
    #     for i in range(4):
    #         # plus case
    #         if num_str[i] == '9':
    #             next_states.append(num_str[:i] + '0' + num_str[i + 1:])
    #         else:
    #             next_states.append(num_str[:i] + chr(ord(num_str[i]) + 1) + num_str[i + 1:])
    #         # minus case
    #         if num_str[i] == '0':
    #             next_states.append(num_str[:i] + '9' + num_str[i + 1:])
    #         else:
    #             next_states.append(num_str[:i] + chr(ord(num_str[i]) - 1) + num_str[i + 1:])
    #     return next_states
    #
    # def openLock(self, deadends, target):
    #     """
    #     :type deadends: List[str]
    #     :type target: str
    #     :rtype: int
    #     """
    #     deadends = set(deadends)
    #     if "0000" in deadends:
    #         return -1
    #
    #     queue = ["0000"]
    #     count = 0
    #     visited = set()
    #     while len(queue) > 0:
    #         size = len(queue)
    #         for i in range(size):
    #             element = queue.pop(0)
    #             if element in visited:
    #                 continue
    #             else:
    #                 visited.add(element)
    #             if element == target:
    #                 return count
    #             next_elements = self.get_next_states(element)
    #             for element in next_elements:
    #                 if element not in deadends:
    #                     queue.append(element)
    #         count += 1
    #     return -1

    def get_next_states(self, num_str):
        next_states = []
        for i, ch in enumerate(num_str):
            # plus case
            next_states.append(num_str[:i] + str((int(ch) + 1) % 10) + num_str[i + 1:])
            # minus case
            next_states.append(num_str[:i] + str((int(ch) - 1) % 10) + num_str[i + 1:])
        return next_states

    def openLock(self, deadends, target):
        """
        :type deadends: List[str]
        :type target: str
        :rtype: int
        """
        visited = set(deadends)
        q = deque(["0000"])
        count = -1
        while q:
            count += 1
            size = len(q)
            for _ in range(size):
                node = q.popleft()
                if node == target: return count
                if node in visited: continue
                visited.add(node)
                q.extend(self.get_next_states(node))
        return -1
# leetcode submit region end(Prohibit modification and deletion)

# print(Solution().openLock(["0201", "0101", "0102", "1212", "2002"], "0202"))
print(Solution().openLock(["0000"], "8888"))
