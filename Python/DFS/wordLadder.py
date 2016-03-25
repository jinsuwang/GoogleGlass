class Solution:

    def ladderLength(self, start, end, dict):
        distance, curr, visited = 0, [start], set([start])
        all_lower_case = "abcdefghijklmnopqrstuvwxyz"
        dict.add(end)
        while curr:
            next = []
            for word in curr:
                if word == end:
                    return distance + 1
                for i in xrange(len(word)):
                    for j in all_lower_case:
                        candicate = word[:i] + j + word[i+1:]
                        if candicate not in visited and candicate in dict:
                            next.append( candicate )
                            visited.add( candicate )
            distance += 1
            curr = next
        return 0
