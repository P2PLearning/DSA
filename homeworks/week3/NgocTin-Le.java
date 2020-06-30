package com.dsa;

public class SingleLinkedList {

    public static void main(String[] args) {
        SinglyLinkedList myLinkedList = new SinglyLinkedList();

        TestRemove(myLinkedList);
        TestAdd(myLinkedList);
        System.out.println("Starting to remove...");
        TestRemove(myLinkedList);
    }

    static void TestAdd(SinglyLinkedList linkedList) {
        linkedList.print(); // empty
        linkedList.add(0, new Node(0));
        linkedList.print(); // 0->null
        linkedList.add(1, new Node(1));
        linkedList.print(); // 0->1->null
        linkedList.add(2, new Node(2));
        linkedList.print(); // 0->1->2->null
        linkedList.add(1, new Node(3));
        linkedList.print(); // 0->3->1->2->null
        linkedList.add(1, new Node(5));
        linkedList.print(); // 0->5->3->1->2->null
        linkedList.add(1, null);
        linkedList.print(); // 0->5->3->1->2->null
        linkedList.add(99, new Node(5));
        linkedList.print(); // 0->5->3->1->2->null
        linkedList.add(-1, new Node(5));
        linkedList.print(); // 0->5->3->1->2->null
        linkedList.add(0, new Node(10));
        linkedList.print(); // 10->0->5->3->1->2->null
        linkedList.add(4, new Node(15));
        linkedList.print(); // 10->0->5->3->15->1->2->null
        linkedList.add(7, new Node(100));
        linkedList.print(); // 10->0->5->3->15->1->2->100->null
    }

    static void TestRemove(SinglyLinkedList linkedList) {
        System.out.println(linkedList.remove(null)); // false
        linkedList.print(); // 10->0->5->3->15->1->2->100->null
        System.out.println(linkedList.remove(new Node(2))); // true
        linkedList.print(); // 10->0->5->3->15->1->100->null
        System.out.println(linkedList.remove(new Node(1))); // true
        linkedList.print(); // 10->0->5->3->15->100->null
        System.out.println(linkedList.remove(new Node(0))); // true
        linkedList.print(); // 10->5->3->15->100->null
        System.out.println(linkedList.remove(new Node(101))); // false
        linkedList.print(); // 10->5->3->15->100->null
        System.out.println(linkedList.remove(new Node(100))); // false
        linkedList.print(); // 10->5->3->15->null
        System.out.println(linkedList.remove(new Node(10))); // false
        linkedList.print(); // 5->3->15->null
        System.out.println(linkedList.remove(new Node(3))); // false
        linkedList.print(); // 5->15->null
        System.out.println(linkedList.remove(new Node(5))); // false
        linkedList.print(); // 15->null
        System.out.println(linkedList.remove(new Node(15))); // false
        linkedList.print(); // empty
    }

    static class SinglyLinkedList {

        private Node head = null;

        // Add to a specific position; do nothing if the index is out of range or e is null
        // Time complexity is O(n), iterate the list the find the position to add
        // Space complexity is O(1)
        public void add(int index, Node e) {
            int listLength = length();

            // Edge cases
            if (index > listLength || index < 0 || e == null) {
                return;
            }

            // Add head to the list
            if (index == 0) {
                e.next = head;
                this.head = e;
                return;
            }

            // Add node somewhere in between the list
            int pos = 0;
            int insertedPos = index - 1;
            Node currNode = this.head;
            Node nextNode = this.head.next;

            // Iterate to the preceding position of the inserted node
            // or until reach the end of the list
            while (pos != insertedPos && nextNode != null) {
                currNode = currNode.next;
                nextNode = nextNode.next;
                pos++;
            }

            currNode.next = e;
            e.next = nextNode;
        }

        // Removes the first occurrence of the specified element from this list if it is present (i.e., its value equals to e.value.
        // Returns true if this list contained the specified element; otherwise, returns false.
        // Time complexity is O(n), iterate the list the find the node to remove
        // Space complexity is O(1)
        public boolean remove(Node e) {
            int listLength = length();

            // Edge cases
            if (listLength == 0 || e == null) {
                return false;
            }

            // If the removed node is the head node
            if (e.value == head.value) {
                head = head.next;
                return true;
            }

            Node prevNode = this.head;
            Node current = this.head.next;

            // Find the removed node
            while (current != null && current.value != e.value) {
                prevNode = prevNode.next;
                current = current.next;
            }

            // The removed node is not existed in the list
            if (current == null) {
                return false;
            }

            // Link the previous node to the next node of the removed node
            prevNode.next = current.next;

            return true;
        }

        public int length() {
            Node current = this.head;
            int count = 0;

            while (current != null) {
                count++;
                current = current.next;
            }

            return count;
        }

        // print linked list
        public void print() {
            if (head == null) {
                System.out.println("empty");
                return;
            }

            Node n = head;
            while (n != null) {
                System.out.print(n.value + "->");
                n = n.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
