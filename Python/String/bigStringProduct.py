class Solution:


	def multipy(self, aaa, bbb ):
		a_list = list(aaa)
		b_list = list(bbb)
		a_list.reverse()
		b_list.reverse()

		ccc = [ 0 for k in range( len(aaa)+ len(bbb)) ]
		for i in range( len(aaa) ):
			for j in range( len(bbb) ):
				ccc[ i + j ] += int(a_list[i])*int(b_list[j])

		for m in range( 0, len(ccc) ):
			if( ccc[m] > 9 ):
				ccc[m+1] += ccc[m]/10
				ccc[m] = ccc[m]%10
		ccc.reverse()
		ccc = "".join([ str(c) for c in ccc ])
		return ccc

print Solution().multipy( "111","100")
