// Problem: Write two SinglyLinkedList operations: add and remove.
public class Main
{
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
  }
    
  static class SinglyLinkedList {

    private Node head = null;
    private int size;
      
    // Add to a specific position; do nothing if the index is out of range or e is null
    public void add(int index, Node e) {
      if (e == null) return;
      //check if index == 0
      if (index == 0) {
        e.next = head;
        head = e;
        return;
      }

      //get prev node
      Node prev = head;
      while (prev != null && index > 1) {
        prev = prev.next;
        index--;
      }
      if (prev == null) return;
      Node next = prev.next;
      e.next = next;
      prev.next = e;
    }

    // Removes the first occurrence of the specified element from this list if it is present (i.e., its value equals to e.value.
    // Returns true if this list contained the specified element; otherwise, returns false.
    public boolean remove(Node e) {
      Node cur = head;
      Node prev = null;
      while (cur != null) {
        if (cur.value == e.value) {
          Node next = cur.next;
          if (prev == null) {//delete first node
            cur = cur.next;
          } else {
            prev.next = next;  
          }
          return true;
        } else {
          cur = cur.next;  
        }
      }
      return false;
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
