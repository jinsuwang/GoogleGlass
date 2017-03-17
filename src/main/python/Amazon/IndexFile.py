
from collections import OrderedDict


def index_file(file):
	ret_dict = {}
	for index, sentence in enumerate(file.split("\n")):
		if sentence:
			line = index + 1
			word_set = set([ word.lower() for word in sentence.split(" ")])
			for word in word_set:
				if word not in ret_dict:
					ret_dict[word] = set([line])
				else:
					ret_dict[word].add(line)				
	return "\n".join([ pair[0]+" "+",".join([ str(count) for count in pair[1]]) for pair in sorted(ret_dict.items())])

test_file = "My name is Simon\nmy favorite color is blue\n\n\nWhy is the sky blue"
print index_file(test_file)