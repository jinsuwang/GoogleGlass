class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: List[str]
        """
        n = len(s)
        possible = [ False for _ in xrange(n) ]
        valid = [ [False] * n for _ in xrange(n) ]
        for i in x xrange(n):
            if s[:i+1] in dict:
                # yes, it's in the 
                possible[i] = True
                valid[0][i] = True
            for j in xrange(i):
                if possible[j] and s[j+1, i+1] in dict:
                    valid[j+1][i] = True
                    possible[i] = True
        ret = []
        if possible[n-1]:
            self.getPath(s, valid, 0, [], ret)
        return ret
        
    def genPath( self, s, valid, start, path, res ):
        if start == len(s):
            ret.append(" ".join(path))
        for i in xrange(start, len(s)):
            if valid[start][i]:
                path += [ s[start:i+1] ]
                self.getPath(s,valid, i+1, path, result)
                path.pop()