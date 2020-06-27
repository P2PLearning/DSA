import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    char[] s = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
    
    char[] output = removeDuplicateCharacters(s);
    // s = {'h', 'e', 'l', 'o', ' ', 'w', 'r', 'l', 'd'};
    for (int i = 0; i < output.length; i++) {
      System.out.print(output[i]);
    }
    // Output: "helo wrd"
  }


  //I go through each element of the input
  //At each element, if it hasn't appear before, then it is added to the output
  //Otherwise, skip this element

  //The space complexity is O(1), as the HashSet and the ArrayList hold a finite number of element
  //The time complexity is O(n), as I go iterate through each element. In each iteration, the contains() method takes O(1) time to search for an element in the Set with finite elements. The add() method takes also O(1) time, although the underlying array of the ArrayList might be extended by copying when it is full. 
  public static char[] removeDuplicateCharacters(char[] s) {

    if ((s==null)||(s.length==0)) return null;

    Set<Character> uniqueCharacterSet = new HashSet<>();
    List<Character> outputList = new ArrayList<>();

    for (int i=0;i<s.length;i++)
    {
      if (!uniqueCharacterSet.contains(s[i]))
      {
        uniqueCharacterSet.add(s[i]);
        outputList.add(s[i]);
      }
    }

    char[] outputArray = new char[outputList.size()];
    for (int i=0;i< outputArray.length;i++)
    outputArray[i] = outputList.get(i);

    return outputArray;
  }

}
