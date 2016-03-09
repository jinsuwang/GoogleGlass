# from heapq import *
import heapq  as pq
# #shift-up
# #shift-down
HEAP_SIZE = 3

test_array = [1,3,47,5,11,73,42,5,1]



heap=[]
# array = [1,2,3]
# pq.heapify(array)
# print pq.heappop(array)
# print len(array)

for e in test_array:
	if len( heap ) < HEAP_SIZE:
		pq.heappush(heap, e)
	else:
		pq.heappushpop(heap, e)

print heap

