from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        tmp_list = []
        i1 = 0
        i2 = 0
        while i1 < m and i2 < n:
            if nums1[i1] <= nums2[i2]:
                tmp_list.append(nums1[i1])
                i1 += 1
            else:
                tmp_list.append(nums2[i2])
                i2 += 1

        while i2 < n:
            tmp_list.append(nums2[i2])
            i2 += 1
        while i1 < m:
            tmp_list.append(nums1[i1])
            i1 += 1
        for i in range(0, len(tmp_list)):
            nums1[i] = tmp_list[i]

