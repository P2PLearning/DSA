"""
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

	static int lowestCommonBoss(int[] boss, int e1, int e2) {

	}
}
"""

boss = [1, 3, 3, -1, -1, 4, 2, 8, 3]


def lowestCommonBoss(boss, e1, e2):
    parent1 = set()
    parent2 = set()
    while True:
        parent1.add(e1)
        parent2.add(e2)
        if e1 in parent2:
            return e1
        if e2 in parent1:
            return e2
        if 0 <= e1 <= len(boss) - 1:
            e1 = boss[e1]
        if 0 <= e2 <= len(boss) - 1:
            e2 = boss[e2]


print(lowestCommonBoss(boss, 1, 1))  # 1
print(lowestCommonBoss(boss, 2, 0))  # 3
print(lowestCommonBoss(boss, 6, 0))  # 3
print(lowestCommonBoss(boss, 7, 1))  # 3
print(lowestCommonBoss(boss, 4, 5))  # 4
print(lowestCommonBoss(boss, 6, 5))  # -1
print(lowestCommonBoss(boss, 4, 2))  # -1
print(lowestCommonBoss(boss, 4, 3))  # -1
print(lowestCommonBoss(boss, 4, -1)) # -1


# Time complexity = Space complexity = log_k (n) //k: maximum number of children in a node; n: length of array

