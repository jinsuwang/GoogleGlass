import Queue
from testTree import test_node

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        sol = []
        queue = Queue.Queue()
        if root == None:
            return sol
        this_level = [root]
        while(this_level):
            this_level_val = []
            next_level = []
            for e in this_level:
                this_level_val.append(e.val)
                if e.left:
                    next_level.append(e.left)
                if e.right:
                    next_level.append(e.right)
            sol.append(this_level_val)
            this_level = next_level
        return sol
        
r = test_node()
s = Solution()
print s.levelOrder(r)
