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
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    int[] boss = { 1, 3, 3, -1, -1, 4, 2, 8, 3 };
    System.out.println(lowestCommonBoss(boss, 1, 1)); // 1
    System.out.println(lowestCommonBoss(boss, 2, 0)); // 3
    System.out.println(lowestCommonBoss(boss, 6, 0)); // 3
    System.out.println(lowestCommonBoss(boss, 7, 1)); // 3
    System.out.println(lowestCommonBoss(boss, 4, 5)); // 4
    System.out.println(lowestCommonBoss(boss, 6, 5)); // -1
    System.out.println(lowestCommonBoss(boss, 4, 2)); // -1
    System.out.println(lowestCommonBoss(boss, 4, 3)); // -1
    System.out.println(lowestCommonBoss(boss, 4, -1)); // -1
  }

  static int lowestCommonBoss(int[] boss, int e1, int e2) {
    if (e1 == e2) {
      return e1;
    }
    if (e1 == -1 || e2 == -1) {
      return -1;
    }

    // check index out of range edge cases
    if (e1 >= boss.length || e2 >= boss.length || e1 < 0 || e2 < 0) {
      return -1;
    }
    HashMap<Integer, Boolean> pathToE1 = new HashMap<>();
    pathToE1.put(e1, true);

    int currentE1Boss = e1;

    // creat path to e1 and save it to HashMap
    while (currentE1Boss != -1) {
      currentE1Boss = boss[currentE1Boss];
      pathToE1.put(currentE1Boss, true);
    }

    int currentE2Boss = e2;

    // travel upward from e2, return the closest boss that matches one of the
    // elements saved in e1's path
    while (currentE2Boss != -1) {
      if (pathToE1.get(currentE2Boss) != null) {
        return currentE2Boss;
      }
      currentE2Boss = boss[currentE2Boss];
    }

    return -1;
  }
}
