class Node:
    def __init__(self, val):
        self.val = val 
        self.next = None
class SinglyLinkedList:
    def __init__(self):
        self.head = Node(float('-inf')) #sentinel node
    def add(self, index, e):
        '''Add e to specific index. Do nothing if index is OOR or e is None'''
        #Time Complexity: O(N), Space: O(1)
        if not e: #e == None
            return
        prev = self.head 
        cur = self.head.next
        while cur and index > 0:
            index -= 1
            prev = cur
            cur = cur.next 
        if index > 0: #Out of range
            return
        else:  #Valid
            prev.next = e
            e.next = cur

    def remove(self, e):
        '''Remove the 1st occurence of e.val from list. Return True if found, else False'''
        #Time Complexity: O(N), Space: O(1)
        if not e:
            return False 
        cur = self.head.next
        prev = self.head
        while cur:
            if cur.val == e.val:
                prev.next = cur.next 
                return True
            prev = cur
            cur = cur.next
        return False
    def __str__(self):
        s = []
        cur = self.head.next 
        while cur:
            s.append(str(cur.val))
            cur = cur.next
        return "->".join(s)
        
def main():
    sll = SinglyLinkedList()
    sll.add(0, Node(0)) #Add 0 to empty SLL
    print(sll)
    sll.add(1, Node(1)) #Add 1 to tail of SLL
    print(sll)
    sll.add(2, Node(2))
    print(sll)
    sll.add(0, Node(4)) #Add 4 to head of SLL
    print(sll)
    sll.add(6, Node(5)) #This is invalid
    print(sll)
    print(sll.remove(Node(3))) #This is invalid
    print(sll.remove(Node(1))) #This is valid
    print(sll)
    print(sll.remove(None)) #this is invalid
main()