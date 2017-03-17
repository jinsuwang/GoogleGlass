def binary_search(items, target):

	first = 0
	last = len(items)-1
	found = False
	while first < last and not found:
		mid = fitst + (last-first)/2
		item = items[mid]
		if item == target:
			return True
		else:
			if taget < items[mid]:
				end = mid -1
			else:
				first = start+1 
