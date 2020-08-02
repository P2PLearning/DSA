package homeworks.week5;

import java.util.HashSet;
import java.util.Set;

public class VuNguyen {
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
        System.out.println(lowestCommonBoss(boss, 4, -1));  // -1

        System.out.println(lowestCommonBoss(boss, 4, -2));  // excep
        System.out.println(lowestCommonBoss(boss, 5, -1));  // excep
    }

    // time complexity: worst is O(h)
    // space complexity: O(n) for set
    static int lowestCommonBoss(int[] boss, int e1, int e2) {
        if (e1 < -1 || e1 >= boss.length) {
            throw new RuntimeException("not Valid");
        }
        if (e2 < -1 || e2 >= boss.length) {
            throw new RuntimeException("not Valid");
        }
        if (e1 == -1 || e2 == -1) {
            return -1;
        }
        Set<Integer> setBoss1 = new HashSet<>();
        Set<Integer> se1Boss2 = new HashSet<>();
        while (e1 != -1 || e2 != -1) {
            setBoss1.add(e1);
            se1Boss2.add(e2);
            if (setBoss1.contains(e2)) {
                return e2;
            }
            if (se1Boss2.contains(e1)) {
                return e1;
            }
            if (e1 != -1) {
                e1 = boss[e1];
            }
            if (e2 != -1) {
                e2 = boss[e2];
            }
        }
        return -1;
    }
}
