class Foo:
	# Awesome Divide and Conquer format 
	def merge_sort( self, in_list ):
		if len(in_list) <= 1:
			return in_list
		mid = len(in_list) / 2 
		left = self.merge_sort( in_list[:mid] )
		right = self.merge_sort( in_list[mid:] )
		return self.merge(left, right)


	def merge(self, left, right):
		""" Merge two list together
		:param left: the left list need to be merge
		:param right: the right list need to be merge 
		"""
		if not left:
			return right
		if not right:
			return left
		if left[0] < right[0]:
			return [left[0]] + self.merge(left[1:], right )
		return [right[0]] + self.merge( left, right[1:])


foo = Foo()
a = [2,4,6,1,3,5]
b = foo.merge_sort(a)
print a
print b 		
