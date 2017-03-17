class Solution:
    def search(self, A, target):
        start, end = 0, len(A)

        while( start < end ):
            mid = start + (end - start) / 2
            if A[mid] == target:
                return mid

            if A[start] <= A[mid]:
                if A[start] <= target and target < A[mid]:
                    end = mid
                else:
                    start = mid + 1
            else:
                if A[mid] < target and target <= A[end-1]:
                    start = mid + 1
                else:
                    end = mid
        return -1