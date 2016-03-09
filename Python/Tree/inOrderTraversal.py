from testTree import test_node

class Solution(object):

    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ## recursive
        # ret = []
        # self.inorderTraversalRecursive(root, ret)
        # return ret

        # Iterative
        ret = self.inorderTraversalIterative(root)
        return ret

    # ireversive
    def inorderTraversalRecursive(self, root, ret):
        if root == None: return
        self.inorderTraversalRecursive(root.left, ret)
        ret.append(root.val)
        self.inorderTraversalRecursive(root.right, ret)

    # iterative using stack
    def inorderTraversalIterative(self, root):
        stack = []
        sol = []
        node = root
        while(node or len(stack)>0):
            if node != None:
                stack.append(node)
                node = node.left
            else:
                node = stack.pop()
                sol.append(node.val)
                node = node.right
        return sol

    def preorderTraversalRecursive(self, root, sol):
        if root == None: return
        sol.append(root.val)
        self.inorderTraversalRecursive(root.left, sol)
        self.inorderTraversalRecursive(root.right, sol)

    def preorderTraversalIterative(self, root):
        stack = []
        sol = []
        node = root
        while(node or len(stack)>0):
            if node != None:
                stack.append(node)
                sol.append(node.val)
                node = node.left
            else:
                node = stack.pop()
                node = node.right
        return sol

    def preorderTraversal(self, root):
        sol = []
        self.preorderTraversalRecursive(root, sol)
        return sol


if __name__ == "__main__":
    root = test_node()
    s = Solution()
    sol = s.preorderTraversalIterative(root)
    print sol
    