import sys
class Solution(object):
    def findMedianSortedArrays2(self, A, B):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        len1, len2 = len(A), len(B)
        if ( len1 + len2 ) %  2 == 1:
            # odd count
            return self.getKth( A, B , (len1+len2) / 2 +1 )
        else:
            return ( self.getKth( A, B ,(len1+len2)/2 ) + self.getKth(A,B,(len1+len2)/2 +1 )) * 0.5


    def getKth2(self, A, B, k):
        m , n = len(A), len(B)
        if m > n:
            return self.getKth(B,A,k)
        left, right = 0, m
        while left < right:
            mid = left + ( right - left ) / 2
            j = k - 1 - mid
            if 0 <= j < n and A[mid] >= B[j]:
                right = mid
            else:
                left = mid + 1
        Ai_minus_1, Bj = -sys.maxint-1, -sys.maxint-1
        if left - 1 >= 0:
            Ai_minus_1 = A[ left - 1 ]
        if k - 1 - left >= 0:
            Bj = B[ k - 1 -left ]
        return max(Ai_minus_1, Bj)

    def findMedianSortedArrays(self, A, B):
        if( A == None ) or ( B == None ): return 0

        total_len = len(A) + len(B)
        if ( total_len % 2 == 0):
            return (self.getKth(A ,B, 0, 0 ,total_len/2) + self.getKth(A, B, 0, 0, total_len/2+1) )/ 2.0
        else:
            return self.getKth(A,B,0,0, total_len/2+1)

    def getKth( self, A, B, index_A, index_B, k ):
        if index_A >= len(A):
            return B[ index_B + k -1 ]
        elif index_B >= len(B):
            return A[index_A + k - 1 ]

        if k == 1 :
            return min(A[index_A], B[index_B])
        mid = k/2 -1
        key_A = sys.maxint if index_A + mid >= len(A) else A[index_A + mid]
        key_B = sys.maxint if index_B + mid >= len(B) else B[index_B + mid]

        k_new = k - k/2

        if key_A < key_B:
            return self.getKth( A ,B , index_A + k/2, index_B, k_new)
        else:
            return self.getKth( A, B, index_A, index_B+ k/2 , k_new)


a = [ 1,3,5 ]
b = [ 2,4,6 ]

print Solution().findMedianSortedArrays(a , b)