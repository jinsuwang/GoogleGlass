
class Solution:

    def groupStrings(self, strings):
        groups = {}
        ret = []
        for s in strings:
            transformed = self.hashStr(s)
            if transformed in groups:
                groups[transformed].append(s)
            else:
                groups[transformed] = [s]
        for k,v in groups.iteritems():
            ret.append(sorted(v))
        return ret


    def hashStr(self,s):
        base = ord(s[0])
        hashcode = ""
        for i in xrange(len(s)):
            if ord(s[i]) - base >= 0:
                hashcode += unichr(ord('a')+ ord(s[i]) - base )
            else:
                hashcode += unichr(ord('a')+ord(s[i])-base + 26)
        return hashcode


# print Solution().hashStr("yza")
