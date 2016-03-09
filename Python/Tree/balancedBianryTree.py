from testTree import test_node

class Solution(object):
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if root == None:
            return True
        return self.isBalancedInt(root) >= 0

    def isBalancedInt(self, root):
        if root == None:
            return 0
        # devide and conquer 
        left = self.isBalancedInt(root.left)
        right = self.isBalancedInt(root.right)
        if left < 0 or right < 0 or abs(left-right) > 1:
            return -1
        return  max(left,right) + 1



if __name__ == "__main__":
    root = test_node()
    s = Solution()
    sol = s.isBalanced(root)
    print sol