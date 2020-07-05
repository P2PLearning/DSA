#!/usr/bin/env python3

class LinkListNode:
    def __init__(self, value):
        self.next = None
        self.value = value

class SinglyLinkedList:
    def __init__(self):
        self.head = None

    # time complexity: O(n)
    # space complexity: O(1)
    def add(self, idx, node):
        if idx == 0:
            if (self.head is not None) and (self.head.next is not None):
                old_next = self.head
                self.head = node
                self.head.next = old_next
            self.head = node
            return True
        if idx != 0 and self.head is None:
            return False

        cur_node = self.head
        tmp = None
        while idx > 0:
            tmp = cur_node
            cur_node = cur_node.next
            idx -= 1

            # idx is bigger than size of the LinkedList
            if cur_node is None and idx > 0:
                return False

        if cur_node is not None:
            old_next = cur_node
            tmp.next = node
            tmp.next.next = old_next
            return True
        tmp.next = node
        return True

    # time complexity: O(n)
    # space complexity: O(1)
    def remove(self, node):
        if node is None:
            return False
        if self.head is None:
            return False

        i = self.head
        if i.value == node.value:
            self.head = self.head.next
            return True

        tmp = None
        while i is not None:
            if i.value == node.value:
                tmp.next = tmp.next.next
                return True
            tmp = i
            i = i.next
        return False

    def representation(self):
        representation = ''
        i = self.head
        if i is None:
            return ""
        else:
            representation = '{}'.format(i.value)
        i = i.next

        while i is not None:
            representation += '->{}'.format(i.value)
            i = i.next
        return representation

    def dump(self):
        print (self.representation())


link_list_test = SinglyLinkedList()

# add an invalid first node
res = link_list_test.add(1, LinkListNode(1))
assert(res == False)
assert(link_list_test.representation() == "")

# remove an item from empty list
res = link_list_test.remove(LinkListNode(1))
assert(res == False)
assert(link_list_test.representation() == "")

# add first node
res = link_list_test.add(0, LinkListNode(1))
assert(res == True)
assert(link_list_test.representation() == "1")

# append to last point of linked list
res = link_list_test.add(1, LinkListNode(2))
assert(res == True)
assert(link_list_test.representation() == "1->2")

# append to last point of linked list
res = link_list_test.add(2, LinkListNode(3))
assert(res == True)
assert(link_list_test.representation() == "1->2->3")

# add to an out-of-bound index value -> return false
res = link_list_test.add(4, LinkListNode(4))
assert(res == False)

# add to middle of the linked list
res = link_list_test.add(1, LinkListNode(9))
assert(res == True)
assert(link_list_test.representation() == "1->9->2->3")

# add to first elem of the linked list
res = link_list_test.add(0, LinkListNode(10))
assert(res == True)
assert(link_list_test.representation() == "10->1->9->2->3")

# remove first element of linked list
res = link_list_test.remove(LinkListNode(10))
assert(res == True)
assert(link_list_test.representation() == "1->9->2->3")

# remove middle element of linked list
res = link_list_test.remove(LinkListNode(9))
assert(res == True)
assert(link_list_test.representation() == "1->2->3")

# remove last element of linked list
res = link_list_test.remove(LinkListNode(3))
assert(res == True)
assert(link_list_test.representation() == "1->2")

# remove all remaining items of linked list
res = link_list_test.remove(LinkListNode(1))
assert(res == True)
assert(link_list_test.representation() == "2")

res = link_list_test.remove(LinkListNode(2))
assert(res == True)
assert(link_list_test.representation() == "")
