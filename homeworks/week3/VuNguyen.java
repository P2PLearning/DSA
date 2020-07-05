// Problem: Write two SinglyLinkedList operations: add and remove.
public class VuNguyen {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.print(); // empty
        linkedList.add(0, new Node(0));
        linkedList.print(); // 0->null
        linkedList.add(1, new Node(1));
        linkedList.print(); // 0->1->null
        linkedList.add(2, new Node(2));
        linkedList.print(); // 0->1->2->null

        System.out.println(linkedList.remove(new Node(2))); // true
        linkedList.print(); // 0->1->null
        System.out.println(linkedList.remove(new Node(1))); // true
        linkedList.print(); // 0->null
        System.out.println(linkedList.remove(new Node(0))); // true
        linkedList.print(); // empty

        linkedList.add(0, null);
        linkedList.print(); // empty

        linkedList.add(1, new Node(99));
        linkedList.print(); // empty


        System.out.println(linkedList.remove(new Node(0))); // false
        linkedList.print(); // empty


        System.out.println(linkedList.remove(new Node(1))); // false
        linkedList.print(); // empty

        linkedList.add(0, new Node(99));
        linkedList.print(); // 99->null
    }

    static class SinglyLinkedList {

        private Node head = null;
        private int size = 0;

        // Time complexity: O(n)
        // Space complexity: O(1)
        public void add(int index, Node e) {
            if (e == null || index > size || index < 0) return; // do nothing if the index is out of range or e is null
            // Add to a specific position;
            size++;
            Node currentNode = this.head;
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                if (i == index) {
                    if (prevNode != null) {
                        prevNode.next = e;
                    } else {
                        head = e;
                    }
                    e.next = currentNode;
                    break;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        // Time complexity: O(n)
        // Space complexity: O(1)
        public boolean remove(Node e) {
            Node currentNode = this.head;
            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                // Removes the first occurrence of the specified element from this list
                // if it is present (i.e., its value equals to e.value.
                if (currentNode.value == e.value) {
                    size--;
                    if (prevNode != null) {
                        prevNode.next = currentNode.next;
                    } else {
                        head = currentNode.next;
                    }
                    return true; // Returns true if this list contained the specified element;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            return false; // otherwise, returns false.
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
