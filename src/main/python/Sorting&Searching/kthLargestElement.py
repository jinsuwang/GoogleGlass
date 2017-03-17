from random import randint
import unittest

class KthLargestElement:

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        # random select
        left = 0; right = len(nums)-1
        while left <= right:
            # pivot_index = randint(left, right)
            pivot_index = 2 
            new_pivot_index = self.parition(left, right, pivot_index, nums)
            print "after partition: nums is {}, new_pivot_index {}, ".format(nums,new_pivot_index)
            if new_pivot_index == k-1:
                return nums[new_pivot_index]
            elif new_pivot_index > k-1:
                right = new_pivot_index -1
            else:
                left = new_pivot_index + 1

    def parition(self, left, right, pivot_index, nums):
        pivot_val = nums[pivot_index]
        print pivot_index, "pivot_val {}".format(pivot_val)
        new_pivot_index = left
        # swap pivot with last value in range
        self.swap(nums, pivot_index, right)
        for i in range(left, right):
            if nums[i] > pivot_val:
                print "swap i:%s, new_pivot_index :%s" %( i, new_pivot_index)
                self.swap(nums, i, new_pivot_index)
                new_pivot_index += 1
        self.swap(nums, new_pivot_index, right)
        print nums
        return new_pivot_index

    def swap(self, nums, left, right):
        nums[left], nums[right] = nums[right], nums[left]


class TestFindKthlargest(unittest.TestCase):
    def setUp(self):
        self.kle = KthLargestElement()

    def test_findKthLargest(self):
        test_arr = [2,1,3,5,4]
        print "return = "+str(self.kle.findKthLargest(test_arr,3))
        self.assertTrue(self.kle.findKthLargest(test_arr,3) == 3)

    # def test_swap(self):
    #     a = [1,2,3]
    #     b = [3,2,1]
    #     self.kle.swap( b, 0, 2) 
    #     self.assertTrue( a == b )

if __name__ == "__main__":
    unittest.main()
