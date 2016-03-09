class Solution:


	def lcs(self, s1, s2):
		min_len = min(len(s1), len(s1))
		for i in range(min_len):
			if s1[i] != s2[i]:
				return s1[:i]
		return s1[:min_len]

	def lrs(self, s):
		s_list = [ s[i:]  for i in range(len(s))]
		s_list.sort()
		# find longest repeared substring by comparing adjacent sorted string
		lrs = ""
		for i in range(len(s_list)-1):
			tmp = self.lcs(s_list[i], s_list[i+1])
			if( len(tmp) > len(lrs) ):
				lrs = tmp
		return lrs


print Solution().lrs("abcdabc")