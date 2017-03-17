class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        lookup = {}
        for i, val in enumerate(nums):
        	if (target - val) in lookup:
        		return [ lookup[target-val], i]
        	else:
        		lookup[val] = i


print Solution().twoSum( [2,7,11,15], 9)