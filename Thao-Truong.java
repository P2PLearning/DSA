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

class Main {
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

  //Time Complexity: O(n^2)
  //Space Complexity: O(1)
	static int lowestCommonBoss(int[] boss, int e1, int e2) {
    if (e1 == e2) {
      return e1;
    }

    if(isBoss(boss, e1,e2)){
      return e2;
    }

    if(isBoss(boss, e2, e1)){
      return e1;
    }

    if(!hasBoss(boss, e1) || !hasBoss(boss, e2)){
      if(!hasBoss(boss, e1)){
        return e1;
      }
      else return e2;
    }

    if(boss[e1] != boss[e2]) {
      return lowestCommonBoss(boss, boss[e1], boss[e2]);
    }
    return boss[e1];
	}

  static boolean hasBoss(int[] boss, int e){
    if(e >= 0 && e <= boss.length - 1){
      return true;
    } 
    else {
      return false;
    }
  }

  static boolean isBoss(int[] boss, int e1, int e2){
    if(!hasBoss(boss, e1) || !hasBoss(boss, e2)){
      return false;
    }

    if(boss[e1] == e2){
      return true;
    }
    else {
      return isBoss(boss, boss[e1], e2);
    }
  }
}
