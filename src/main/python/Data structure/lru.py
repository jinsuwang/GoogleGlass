class DoubleLinkedListNode:

    def __init__(self,key,val):
        self.val = val
        self.key = key
        self.prev = None
        self.next = None


class DoubleLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def insert(self, node):
        if not self.head:
            self.head = node
        else:
            node.prev = self.tail
            self.tail.next = node
        self.tail = node

    def delete(self,node):
        if node.prev: # not head
            node.prev.next = node.next # upgrade one 
        else: # head
            self.head = node
        if node.next: # not tail
            node.next.prev = node.prev
        else:
            self.tail = node.prev
        del node



class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.dll = DoubleLinkedList()
        self.dict = dict()
        self.capacity = capacity

    def _insert(self, key, val):
        node = DoubleLinkedListNode(key, val)
        self.dll.insert(node)
        self.dict[key] = node
        
    def get(self, key):
        """
        :rtype: int
        """
        if key in self.dict:
            val = self.dict[key].val
            self.dll.delete(self.dict[key])
            self._insert(self.dict[key],val)
            return val
        return -1


    def set(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: nothing
        """
        if key in self.dict:
            # key in cache
            del self.dll.delete[self.dict[key]]
        elif len(self.dict) == self.capacity: # Full !
            del self.dict[self.dll.head.key]
            self.dll.delete(self.dll.head)
        self._insert(key,value)