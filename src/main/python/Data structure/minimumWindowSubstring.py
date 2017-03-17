class Solution(object):
 def minWindow(self, S, T):
		curr_count = [ 0 for i in range(52) ]
		expected_count = [ 0 for i in range(52) ]
		asc_a = ord("a")
		for char in T:
			expected_count[ ord(char) - asc_a] += 1
		i = 0 # scan index
		start = 0 # start index
		count = 0 # total charactor showed up
		min_width = sys.maxint # the width of return value
		min_start = 0 # start index for return
		
		while( i < len(S) ):
		    # populate curr_count array
			curr_count[ord(S[i]) - asc_a] += 1
			# Cool, one char finished!
			if expected_count[ord(S[i]) - asc_a] >= curr_count[ord(S[i]) - asc_a]:
				count += 1
			# all char showed up	
			if count == len(T):
			    # char not in T or curr count greater than expected count
				while expected_count[ ord(S[start])-asc_a ] == 0 or curr_count[ord(S[start])-asc_a] > expected_count[ord(S[start])-asc_a]:
					curr_count[ord(S[start]) - asc_a] -= 1
					start += 1
				# update minimum length of string
				if i - start + 1 < min_width:
					min_width = i - start + 1
					min_start = start
			i += 1

		if min_width == sys.maxint:
			return ""
		return S[min_start: min_start + min_width]