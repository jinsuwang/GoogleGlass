class Solution:

	def combinationSum(self, candidates, target):
		ret = []
		self.combinationSumDFS(sorted(candidates), ret, 0, [], target )
		return ret

	def combinationSumDFS(self, candidates, ret, start, inter, target):
		if target == 0:
			ret.append(list(inter))
		while start < len(candidates) and candidates[start] <= target:
			inter.append(  candidates[start] )
			self.combinationSumDFS( candidates, ret, start, inter, target- candidates[start])
			inter.pop()
			start += 1

print Solution().combinationSum([2,3,6,7], 7) 