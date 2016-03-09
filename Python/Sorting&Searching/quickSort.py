class Solution:
	def quick_sort(self, array):
		self.quick_sort_helper(array, 0, len(array)-1)

	def quick_sort_helper(self, array, start, end):
		if start >= end:
			return
		pivot_index = self.partition(array, start, end)
		self.quick_sort_helper( array, start, pivot_index-1)
		self.quick_sort_helper( array, pivot_index+1, end)

	def partition(self, array, start, end):
		pivot_index = start
		left = start + 1
		right = end + 1
		for i in range( left,  right): # end is index
			if array[i] <= array[start]:
				pivot_index += 1
				array[i], array[pivot_index] = array[pivot_index], array[i]
		array[pivot_index], array[start] = array[start], array[pivot_index]
		return pivot_index



a = [97, 200, 100, 101, 211, 107]
Solution().quick_sort(a)
print a