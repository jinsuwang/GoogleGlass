class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        tmp = [False for i in range(len(s)+1)]
        tmp[0] = True

        for i in range(1, len(tmp)):
            # init set to be False
            tmp[i] = False
            for j in range( 0, i ):
                if tmp[j] and s[j:i] in wordDict:
                    tmp[i] = True
                    break
        return tmp[-1]
