// Problem: Write two SinglyLinkedList operations: add and remove.
public class Main
{
	public static void main(String[] args) {
    SinglyLinkedList linkedList = new SinglyLinkedList();
    linkedList.print(); // empty
    linkedList.add(0, new Node(0));  //0->null  
    linkedList.add(1, new Node(1));  //0->1->null   
    linkedList.add(2, new Node(2));  //0->1->->2->null  
    linkedList.add(5, new Node(3));  //invalid input, linked list is not changed 
    linkedList.add(0, new Node(9));  //9->0->1->->2->null 
    linkedList.add(-1, new Node(9)); //invalid input, linked list is not changed  
    linkedList.print();              //9->0->1->->2->null 
    

    System.out.println(linkedList.remove(new Node(2))); // true
    linkedList.print(); // 9->0->1->null
    System.out.println(linkedList.remove(new Node(2))); // false
    linkedList.print(); // 9->0->1->null
    System.out.println(linkedList.remove(new Node(1))); // true
    linkedList.print(); // 9->0->null
    System.out.println(linkedList.remove(new Node(0))); // true
    linkedList.print(); // 9->null
    System.out.println(linkedList.remove(new Node(9))); // true
    linkedList.print(); // empty
    System.out.println(linkedList.remove(new Node(9))); // false
    linkedList.print(); // empty
	}
    
  static class SinglyLinkedList {

    private Node head = null;      
    
    public void add(int index, Node e) {

      //check if the Node is null (adge case), then do nothing
      if (e==null) return;

      Node temp = head;

      //If insert at the head of the linked list, it is a bit different from other positions
      if (index==0)
      {
        head = e;
        e.next = temp;
      }      
      else if (index >0)
      {
        int count = 0;        

        while ((count < index)&&(temp.next != null))
        {
          temp = temp.next;
          count++;
        }

        if (count==index-1) //"index" parameter is within the length of the linked list
        {
          if (temp.next==null) //insert at last position of the linked list
          {
            temp.next=e;
          }
          else // insert in the middle of the linked list
          {
            Node tempNext = temp.next;
            temp.next = e;
            e.next = tempNext;
          }         
          
        }
        else // "index" parameter is beyond the length of the linked list
        return;
      }
      else  //"index" parameter is a negative int, which is invalid, then do nothing
        return;

    }
    
    public boolean remove(Node e) {

      boolean result = false;

      if (head==null) //The linked list is empty, then do nothing
      return result;

      if (head.value ==e.value) //Remove at the head of the linked list
      {
        head = head.next;
        result = true;
      }
      else 
      {
        Node temp = head.next; //The temporary variable to store the current pointer
        Node prevTemp = head; //The temporary variable to store the immediately previous node of the current pointer      

        while (temp !=null)
        {
          if (temp==null) //At the end of the linked list, the node to be removed is not found then do nothing and return false
          {
            result = false;
            break;
          }
          else //The node to be removed is found, then it is removed
          {
            if (temp.value == e.value)
            {
              result = true;
              prevTemp.next = temp.next;
              break;
            }
          }

          temp = temp.next; //Move the current pointer 1 node ahead
          prevTemp = prevTemp.next; //Move the immediately previous node of the current pointer 1 node ahead
        }  
      }          
      return result;
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
