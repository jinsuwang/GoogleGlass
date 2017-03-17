class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        if len(needle) > len(haystack):
            return -1
        for x in range(0, len(haystack)-len(needle)+1):
            if haystack[x:x+len(needle)] == needle:
                return x
        return -1



class FindAllNeedleInHaystack:

    def find_index(self, haystack, needle):
        ret = []
        for x in range(0, len(haystack)-len(needle)+1):
            if haystack[x:x+len(needle)] == needle:
                ret.append(x)
                x += len(needle)
        return ret


s = FindAllNeedleInHaystack()
print s.find_index("abababa", "ab")
