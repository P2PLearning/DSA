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
        //Edge cases
        System.out.println(lowestCommonBoss(boss, 3,3)); // 3
        System.out.println(lowestCommonBoss(boss, 9, 10)); // null
        System.out.println(lowestCommonBoss(boss, 0, 10)); // null
    }

    static Integer lowestCommonBoss(int[] boss, int e1, int e2) {
        if (e1 == e2) return e1;
        if ((e1 > boss.length || e1 < -1) || (e2 > boss.length || e2 < -1)) return null;
        ArrayList<Integer> traceE1 = traverseToRoot(boss, e1);
        ArrayList<Integer> traceE2 = traverseToRoot(boss, e2);
        int lowestCommonBoss = -2;
        for(int i = 1; i <= Math.min(traceE1.size(), traceE2.size()); i++){ // O(h) time
            if(traceE1.get(traceE1.size()-i) == traceE2.get(traceE2.size()-i))
                lowestCommonBoss = traceE1.get(traceE1.size()-i);
            else
                break;
        }
        return lowestCommonBoss;
    }
    static ArrayList<Integer> traverseToRoot(int[] boss, int number){
        int index = number;
        ArrayList<Integer> trace = new ArrayList<Integer>(); // O(h) space
        trace.add(number);
        while (index != -1){ // O(h) time. Worse case: skewed tree, O(n).
            index = boss[index];
            trace.add(index);
        }
        return trace;
    }
    // Sorry I didn't come up a solution without using additional storage.
    // Time Complexity: O(h)
    // Space Complexity: O(h)
}
