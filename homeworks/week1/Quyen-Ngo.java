public class Main {
  public static void main(String[] args) {
    System.out.println("Minimum element: " + findMinimum(new int[] { 3, 4, 5, 1, 2 })); //1
    System.out.println("Minimum element: " + findMinimum(null)); //Integer.MIN_VALUE
    System.out.println("Minimum element: " + findMinimum(new int[] { })); //Integer.MIN_VALUE
    System.out.println("Minimum element: " + findMinimum(new int[] { 4, 5, 6, 7, 0, 1, 2 })); //0
  }

  // Finds the minimum number in a rotated sorted array of integers. Returns Integer.MIN_VALUE for invalid input.
  // complexity of this algorithm is O(n) ; I am trying to improve it
  // space complexity O(1);

  public static int findMinimum(int[] array) {

      int min;

      if (array == null || array.length == 0) {
          return Integer.MIN_VALUE;
      } else {
          min = array[0];
          for (int i= 0; i<array.length; i++) {
              if (min > array[i]) {
                  min = array[i];
              }
          }
          return min;
      }
    
  }
}


// Another try with the time complexity of O(2logn) and space complexity O(1)

public class RotatedSortedArrayFindMinimum {
	
	public static void main(String []args){
        System.out.println("Minimum element: " + findMinimum(new int[] { 3, 4, 5, 1, 2 })); //1
    System.out.println("Minimum element: " + findMinimum(null)); //Integer.MIN_VALUE
    System.out.println("Minimum element: " + findMinimum(new int[] { })); //Integer.MIN_VALUE
    System.out.println("Minimum element: " + findMinimum(new int[] { 4, 5, 6, 7, 0, 1, 2 })); //0
  }

  // Finds the minimum number in a rotated sorted array of integers. Returns Integer.MIN_VALUE for invalid input.

  public static int findMinimum(int[] array) {
    if (array == null || array.length == 0) {
      return Integer.MIN_VALUE;
    }
    int left = 0;
    int right = array.length -1;
    int element = findPivot(array, left, right);
    return element;
  }

  public static int findPivot(int[] array, int left, int right) {
    int mid = (right + left) / 2;
    if (array[mid]>array[mid+1]) {
      return array[mid+1];
    } else {
        if (array[mid] < array[left]) {
          findPivot(array, left -1, mid);
        } else {
          findPivot(array, mid +1, right);
        }
    }
    return -1;
    
  }

}
