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
      // Time complexity is expected to be O(n) at worse and O(1) for best case
      // Space complexity is O(1)
    // Add to a specific position; do nothing if the index is out of range or e is null
    public void add(int index, Node e) {
      int a = range();
      if(index> a+1) return;
      if(e==null) return;
      Node t;
      
      t = head;
      if(head ==null) {head =e; return;}
      for(int i =0;i<index-1;i++ ){
          t = t.next;
          
     }
      e.next = t.next;     
       
      t.next =e;




    }
	// Similarly with add function, Time complexity is expected to be O(n) at worse and O(1) for best case
      // Space complexity is O(1)
    // Removes thet first occurrence of he specified element from this list if it is present (i.e., its value equals to e.value.
    // Returns true if this list contained the specified element; otherwise, returns false.
    public boolean remove(Node e) {
      Node t=head;
      if(t.value ==e.value) 
      {head = head.next;
      return true;
      }
      while(true){
          
        
        
        if(t.next.value==e.value) {
            t.next=t.next.next;
            return true;
        }
         
        
        if(t==null) return false;
        t=t.next;
      }

    }
    //range function
    // count the number of element inside the list

    public int range() {
        int count=0;
        Node t = head;
        if(head ==null) return count;
        while(true){
          t= t.next;
          count++;
          if(t==null) break;
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
