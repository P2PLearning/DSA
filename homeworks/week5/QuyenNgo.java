// Find lowest common boss in a tree;
// Input: [1, 3, 3, -1, -1, 4, 2, 8, 3]
// 0 reports to 1, 1 reports to 3, 2 reports to 3, 3 reports to -1 (highest boss), etc.
//      -1
//     /  \
//    3    4
//  / | \   \
// 8  2  1   5
// |  |  |
// 7  6  0
// Assumption: the input array is non-empty. And  and valid inputs.
// Requirement: No extra storage. No build-in library.
import java.util.ArrayList;



//Time complexity O(n)
//Space complexity O(n)
public class QuyenNgo {
  public static void main(String[] args) {
    int[] boss = { 1, 3, 3, -1, -1, 4, 2, 8, 3 };
    System.out.println(lowestCommonBoss(boss, 1, 1));  // 1
	System.out.println(lowestCommonBoss(boss, 2, 0));  // 3
    System.out.println(lowestCommonBoss(boss, 6, 0));  // 3
    System.out.println(lowestCommonBoss(boss, 7, 1));  // 3
    System.out.println(lowestCommonBoss(boss, 4, 5));  // 4
    System.out.println(lowestCommonBoss(boss, 6, 5));  // -1
    System.out.println(lowestCommonBoss(boss, 4, 2));  // -1
    System.out.println(lowestCommonBoss(boss, 4, 3));  // -1
    System.out.println(lowestCommonBoss(boss, 4, -1));  // -1
  }

	static int lowestCommonBoss(int[] boss, int e1, int e2) {
	    ArrayList<Integer> path1 = findPath(boss, e1);
	    ArrayList<Integer> path2 = findPath(boss, e2);
	    
//	    System.out.println(path1);
//	    System.out.println(path2);

	    
	    int n = path1.size();
	    int m = path2.size();

	    
	    if((n==1 && path1.get(n-1)==-1) ||(m==1 &&path2.get(m-1)==-1)) {
	        return -1;
	    }
	    
	    int countSame=1;
	    if (n<= m) {
	        for (int i=2; i<= n;i++){
	            if (path1.get(n-i) != path2.get(m-i)) {
	                return path1.get(n-i+1);
	            } else {
	            	countSame++;
	            }
	        }
	        if (countSame == n) {return path1.get(0);}
	    } else {
	    	for (int i=2; i<=m;i++){
	            if (path2.get(m-i) != path1.get(n-i)) {
	                return path2.get(m-i+1);
	            } else {
	            	countSame++;
	            }
	    	}
	    	if(countSame == m) {return path2.get(0);}
	    }
	    return 100;

	}
	

	
	static ArrayList<Integer> findPath(int[] boss, int e) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    if (e == -1) {
	        arr.add(-1);
	        return arr;
	    }
	    while (e!= -1) {
	        arr.add(e);
	        e = boss[e];
	    }
	    arr.add(-1);
	    return arr;
	}
}



