class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums, result, i = sorted(nums), [], 0
        for i in range(len(nums)):
            if i > 0  and nums[i] == nums[i-1]:
                continue
            l = i + 1
            r = len(nums) - 1
            while(l < r):
                total = nums[i] + nums[l] + nums[r]
                if ( total == 0 ):
                    result.append([ nums[i], nums[l], nums[r]])
                    l += 1; r -= 1
                    while l < r and nums[l] == nums[l-1]: l +=1
                    while l < r and nums[r] == nums[r+1]: r -= 1
                elif total > 0:
                    r -= 1
                else:
                    l += 1
        return result

print Solution().threeSum([-1,0,1,2,-1,-4])