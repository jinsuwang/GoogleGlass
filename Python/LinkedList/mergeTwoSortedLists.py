class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1 and not l2:
            return ret
        elif not l1:
            return l2
        elif not l2:
            return l1
        dummy = ListNode(0)
        tmp = dummy;
        while( l1 and l2 ):
            if l1.val <= l2.val:
                tmp.next = l1
                l1 = l1.next
            else:
                tmp.next = l2
                l2 = l2.next
            tmp = tmp.next
        if l1:
            tmp.next = l1
        else:
            tmp.next = l2
        return dummy.next

a=ListNode(1); b=ListNode(3); c=ListNode(5); a.next = b; b.next = c
d=ListNode(2); e=ListNode(4); f=ListNode(6); d.next = e; e.next = f

def print_node(node):
    while(node):
        print node.val,
        node = node.next

s = Solution()
r = s.mergeTwoLists(a,d)
print_node(r)


