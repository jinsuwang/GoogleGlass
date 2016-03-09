class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def test_node():
	n1 = TreeNode(1)
	n2 = TreeNode(2)
	n3 = TreeNode(3)
	n4 = TreeNode(4)
	n5 = TreeNode(5)
	n6 = TreeNode(6)
	n7 = TreeNode(7)
	n4.left = n2
	n2.left = n1
	n2.right = n3
	n4.right = n6
	n6.left = n5
	n6.right = n7
	return n4
