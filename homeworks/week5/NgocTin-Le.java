package com.dsa;

//int[] boss = { 1, 3, 3, -1 };

// Find lowest common boss in a tree;
//         0  1  2   3   4  5  6  7  8
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
// bossK = input[k]

// 2 0
// 1 3
// 3 -1

//7 1
//8 3
//3 -1

// 6 0
// 2 1
// 3 3
// -1

// 6 5
// 2 4
// 3 -1

import java.util.Comparator;
import java.util.PriorityQueue;

public class LowestCommonBoss {
    public static void main(String[] args) {
        int[] boss = {1, 3, 3, -1, -1, 4, 2, 8, 3};
        System.out.println(lowestCommonBoss(boss, 1, 1));  // 1
        System.out.println(lowestCommonBoss(boss, 2, 0));  // 3
        System.out.println(lowestCommonBoss(boss, 6, 0));  // 3
        System.out.println(lowestCommonBoss(boss, 7, 1));  // 3
        System.out.println(lowestCommonBoss(boss, 4, 5));  // 4
        System.out.println(lowestCommonBoss(boss, 6, 5));  // -1
        System.out.println(lowestCommonBoss(boss, 4, 2));  // -1
        System.out.println(lowestCommonBoss(boss, 4, 3));  // -1
        System.out.println(lowestCommonBoss(boss, 4, -1)); // -1
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    // Using priority queue
    static int lowestCommonBoss(int[] boss, int e1, int e2) {

        // Edge cases
        if (e1 == -1 || e2 == -1) {
            return -1;
        }

        if (e1 == e2) {
            return e1;
        }

        int e1Boss = boss[e1];
        int e2Boss = boss[e2];
        int higherBoss = 0;

        // Edge cases
        if (e1Boss == e2Boss) {
            return e1Boss;
        }

        if(e1 == e2Boss) {
            return e1;
        }

        if(e2 == e1Boss) {
            return e2;
        }

        PriorityQueue<Integer> commonBoss = new PriorityQueue<Integer>(2, (o1, o2) -> {
            if (o1.intValue() == o2.intValue()) return 0;
            return o1.intValue() < o2.intValue() ? -1 : 1;
        });

        while (higherBoss != -1) {

            commonBoss.add(e1Boss);
            commonBoss.add(e2Boss);

            if(e1Boss == e2Boss) {
                return e1Boss;
            }

            if (e1Boss != -1) {
                e1Boss = boss[e1Boss];
            }

            if (e2Boss != -1) {
                e2Boss = boss[e2Boss];
            }

            higherBoss = commonBoss.poll();
        }

        if(commonBoss.size() == 1){
            return  higherBoss;
        }

        return commonBoss.poll();
    }
}
