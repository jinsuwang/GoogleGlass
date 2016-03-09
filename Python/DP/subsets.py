class Solution(object):
    # recursion
    def subsets(self, nums):
        def dfs(level, index, e):
            sol.append(e)
            if level == len(nums): return
            for i in range(index, len(nums)):
                dfs(level+1, i+1, e+[nums[i]] )             
        sol = []
        dfs(0,0,[])
        return sol

    # Iterative

    # Bit manipulation

    


s = Solution()
print s.subsets([1,2,3])


        

        