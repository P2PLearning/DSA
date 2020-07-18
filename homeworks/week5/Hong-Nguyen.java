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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

  /*
    time complexity: O(n)
    space complexity: O(n)

    idea is we can use Map as the tree and go from -1 to find the e1 and e2
    if one node can have the matching count >=2 means that that node is e1 or e2
    and there is the child of that node is e1 or e2
    then we set ans to that node

    if the node has only 1 match, means that the other node in other tree branch
  */
    static Integer res;
    static int lowestCommonBoss(int[] boss, int e1, int e2) {
        Map<Integer, Set<Integer>> tree = new HashMap<>();
        for (int i = 0; i < boss.length;i++) {
            int parent = boss[i];
            tree.computeIfAbsent(parent, k -> new HashSet<Integer>()).add(i);
        }
        lowestCommonBoss(tree, -1, e1, e2);
        return res;
    }

    static Integer lowestCommonBoss(Map<Integer, Set<Integer>> tree, Integer node, int e1, int e2) {
        if (node == null) return null;
        int mid = 0;
        if (e1 == e2) {
            mid = node == e1 ? 2: 0;
        } else {
            mid = node == e1 || node == e2 ? 1 : 0;
        }

        Set<Integer> children = tree.get(node);
        int childMatchCnt = 0;
        if(children != null && !children.isEmpty()) {
            for (Integer child: children) {
                Integer matchedNode = lowestCommonBoss(tree, child, e1, e2);
                childMatchCnt += matchedNode != null ? 1 : 0;
            }
        }
        if (mid + childMatchCnt >= 2) res = node;
        return mid + childMatchCnt > 0 ? node : null;
    }
}
