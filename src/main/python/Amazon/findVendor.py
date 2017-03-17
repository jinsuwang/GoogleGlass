

def findMaxVendor(input_list):
	item_frequency = dict()
	inverse_item_frequency = dict()
	for e in input_list:
		vendor, item = e.split(",")
		# update item_frequency
		if vendor not in item_frequency:
			item_frequency[vendor] = set([item])
		else:
			item_frequency[vendor].add(item)
		# update inverse_item_frequency 
		if item not in inverse_item_frequency:
			inverse_item_frequency[item] = set([vendor])
		else:
			inverse_item_frequency[item].add(vendor)
	duplicate = dict()
	for vendor,items in item_frequency.iteritems():
		for item in items:
			if vendor not in duplicate:
				duplicate[vendor] = 0
			duplicate[vendor] += len(inverse_item_frequency[item])-1

	return item_frequency, inverse_item_frequency,duplicate

test_input = [ "A,1", "B,1", "A,2", "C,3", "A,3", "B,2" ]

item_frequency, inverse_item_frequency, duplicate = findMaxVendor(test_input)

print item_frequency
print inverse_item_frequency
print duplicate



