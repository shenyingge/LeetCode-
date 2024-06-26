from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        num_set = set()
        for num in nums:
            num_set.add(num)
        num_set = list(num_set)
        for i in range(0, len(num_set)):
            nums[i] = num_set[i]
        return len(num_set)
