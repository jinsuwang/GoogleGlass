class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        look_up = {"[" : "]", "{" : "}", "(" : ")"}
        stack = []
        left = look_up.keys()
        right = look_up.values()
        for c in s:
        	if c in look_up:
        		stack.append(c)
        	elif c in right:
        		if len(stack) == 0 or look_up[stack.pop()] != c:
        			return False
        return len(stack) == 0


print Solution().isValid("{[()]}")


