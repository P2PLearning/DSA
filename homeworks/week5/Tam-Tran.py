#!/usr/bin/env python3

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

# time complexity = space complexity = O(H), H: height of the tree
def lowest_common_boss(boss, employee_1, employee_2):
    boss1 = set()
    boss2 = set()

    while True:
        boss1.add(employee_1)
        boss2.add(employee_2)

        # found boss when traverse up
        if employee_1 in boss2:
            return employee_1
        if employee_2 in boss1:
            return employee_2

        if employee_1 != -1:
            employee_1 = boss[employee_1]
        if employee_2 != -1:
            employee_2 = boss[employee_2]


boss = [1, 3, 3, -1, -1, 4, 2, 8, 3]

assert(lowest_common_boss(boss, 1, 1) == 1)
assert(lowest_common_boss(boss, 2, 0) == 3)
assert(lowest_common_boss(boss, 6, 0) == 3)
assert(lowest_common_boss(boss, 7, 1) == 3)
assert(lowest_common_boss(boss, 4, 5) == 4)
assert(lowest_common_boss(boss, 6, 5) == -1)
assert(lowest_common_boss(boss, 4, 2) == -1)
assert(lowest_common_boss(boss, 4, 3) == -1)
assert(lowest_common_boss(boss, 4, -1) == -1)
