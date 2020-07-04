

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
    private int size = 0;
      
    // Add to a specific position; do nothing if the index is out of range or e is null
    public void add(int index, Node e) {

      //check if index out of range
        if(index > size){
          return;
        }

        if (this.head == null) {
            //if head is null and position is zero then exit.
            if (index != 0) {
                return;
            } else { //node set to the head.
                this.head = e;
                this.size ++;
                return;
            }
        }

        if (head != null && index == 0) {
            e.next = this.head;
            this.head = e;
            this.size ++;
            return;
        }

        Node current = this.head;
        Node previous = null;

        int i = 0;

        while (i < index) {
            previous = current;
            current = current.next;
            i++;
        }

        e.next = current;
        previous.next = e;
        this.size++;
    }

    // Removes the first occurrence of the specified element from this list if it is present (i.e., its value equals to e.value.
    // Returns true if this list contained the specified element; otherwise, returns false.
    public boolean remove(Node e) {
      //Check if linked list has 1 element
      if( this.size == 1 ){
        if(e.value == head.value){
          head = null;
          return true;
        }
        else return false;
      }

      Node current = this.head;
      Node previous = null;

      int i = 0;

      while (i < this.size) {
          previous = current;
          current = current.next;
          if(e.value == current.value){
            break;
          }
          i++;
      }
      if(i == this.size){
        return false;
      }
      previous.next = current.next;
      this.size--;
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
