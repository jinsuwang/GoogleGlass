import copy
class Solution:
    def subsets(self, nums):
        ret = []
        curr = []
        nums.sort()
        self.dfs(ret, curr, nums, 0)
        return ret
        
    def dfs(self, ret, curr, nums, index):
        ret.append(copy.copy(curr))
        if index == len(nums):
            return;
        for i in range(index,len(nums)):
            curr.append(nums[i])
            self.dfs(ret, curr, nums, i+1)
            curr.pop()

print Solution().subsets(["1","2","3"])

