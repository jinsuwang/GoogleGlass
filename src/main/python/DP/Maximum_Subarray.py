from sys import maxint
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums: return 0
        max_val = 0
        sol = -maxint
        for i in range(0,len(nums)):
            max_val = max(nums[i], max_val+nums[i])
            sol = max( max_val, sol )
        return sol

s = Solution()
print s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])



                