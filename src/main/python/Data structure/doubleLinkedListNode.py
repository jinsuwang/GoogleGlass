class DoubleLinkedListNode:

	def __init__(self):
		self.val = None
		self.key = None
		self.prev = None
		self.next = None


class DoubleLinkedList:

	def __init__(self):
		self.head = head
		self.tail = tail

	def insert(self, node):
		if not self.head:
			self.head = node
		else:
			self.tail.next = node
			node.prev = self.tail
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




