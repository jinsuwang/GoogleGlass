import unittest
import copy
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        ret = []
        used = [False]*len(nums)
        self.permute_recur(ret, used, nums, [])
        return ret


    def permute_recur(self, ret, used, nums, curr):
        if len(curr) == len(nums):
            ret.append(copy.copy(curr))
            return 
        for i in range(len(nums)):
            if used[i]:
                continue
            else:
                used[i] = True
                curr.append( nums[i] )
                self.permute_recur(ret, used, nums, curr)
                curr.pop()
                used[i]=False


class Test(unittest.TestCase):
    def setUp(self):
        self.sol = Solution()
        self.test_list =[1,2,3]

    def test_permute(self):
        print self.sol.permute(self.test_list)

if __name__ == "__main__":
    unittest.main()

