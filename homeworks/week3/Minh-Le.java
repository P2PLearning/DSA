//Repl link: https://repl.it/@MinhD1/SinglyLinkedList#Main.java

// Problem: Write two SinglyLinkedList operations: add and remove.
public class Main
{
	public static void main(String[] args) {
    SinglyLinkedList linkedList = new SinglyLinkedList();

    // move from empty list
    System.out.println(linkedList.remove(new Node(1))); // false

    linkedList.print(); // empty
    linkedList.add(0, new Node(0));
    linkedList.print(); // 0->null
    linkedList.add(1, new Node(1));
    linkedList.print(); // 0->1->null
    linkedList.add(2, new Node(2));
    linkedList.print(); // 0->1->2->null

    // add to the middle of the list
    linkedList.add(1, new Node(3));
    linkedList.print(); // 0->3->1->2->null

    //index out of range, do nothing
    linkedList.add(5, new Node(4));
    linkedList.print(); // 0->3->1->2->null

    // remove element that is not found
    System.out.println(linkedList.remove(new Node(4))); // false
    linkedList.print(); // 0->3->1->2->null

    //remove last element
    System.out.println(linkedList.remove(new Node(2))); // true
    linkedList.print(); // 0->3->1->null

    //remove element in the middle
    System.out.println(linkedList.remove(new Node(3))); // true
    linkedList.print(); // 0->1->null

    //remove first element
    System.out.println(linkedList.remove(new Node(0))); // true
    linkedList.print(); // 1->null

     //remove the only element
    System.out.println(linkedList.remove(new Node(1))); // true
    linkedList.print(); // empty
	}
    
  static class SinglyLinkedList {

    private Node head = null;
      
    // Add to a specific position; do nothing if the index is out of range or e is null
    // Time complexity: worst case O(n), best case O(1), space complexity: O(1)
    public void add(int index, Node e) {
      if (e == null) return;

      if (this.head == null && index == 0) {
        this.head = e;
        return;
      }

      int count = 0;
      Node prev = null;
      Node curr = this.head;
      for (int i = 0; i < index && curr != null; i++) {
        prev = curr;
        curr = curr.next;
        count++;
      }

      if (count < index) { // index out of range, do nothing
        return; 
      }

      e.next = curr;
      
      if (prev != null) {
        prev.next = e;
      } else { // add to the beginning
        this.head = e;
      }
    }

    // Removes the first occurrence of the specified element from this list if it is present (i.e., its value equals to e.value.
    // Returns true if this list contained the specified element; otherwise, returns false.

    // Time complexity: worst case O(n), best case O(1), space complexity: O(1)
    public boolean remove(Node e) {
      if (this.head == null || e == null) { return false; }
      Node prev = null;
      Node curr = this.head;
      
      // find the element
      while (curr != null && curr.value != e.value) {
        prev = curr;
        curr = curr.next;
      }

      if (curr == null) { // element not found
        return false;
      }

      if (prev == null) { // remove the first element
        this.head = curr.next;
      } else {
        prev.next = curr.next;
      }

      return true;
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
