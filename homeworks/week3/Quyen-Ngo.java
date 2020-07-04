public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
}

static class SinglyLinkedList {
	private Node head = null;
    
    // Add to a specific position; do nothing if the index is out of range or e is null
	//Add function: Time Complexity O(n)
	//Add function: Space Complexity O(1)
    public void add(int index, Node e) {
    	
    	if (head == null) {
    		head = e;
    		return;
    	}
    	
    	Node prev = head;
    	int count =1;
    	while(count < index -1) {
    		prev = prev.next;
    		count++;
    	}
    	
    	
    	Node curr = prev.next;
    	e.next = curr;
    	prev.next = e;
    }

    // Removes the first occurrence of the specified element from this list if it is present (i.e., its value equals to e.value.
    // Returns true if this list contained the specified element; otherwise, returns false.
    
    //Remove function: Time Complexity O(n)
    //Remove function: Space Complexity O(1)
    public boolean remove(Node e) {
    	
    	Node curr = head;
    	Node prev = null;
    	
    	if (curr!= null && curr.value == e.value) {
    		head = curr.next;
    		return true;
    	}
    	
    	while(curr!= null && curr.value != e.value) {
    		prev = curr;
    		curr = curr.next;
    	}
    	
    	if (curr == null) {
    		return false;
    	}
    	
    	prev.next = curr.next;
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
