package homeworks.week4;

public class VuNguyen {
    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1, 3),
                new Interval(2, 5),
        };

        int[] count = new int[5];
        int iterations = 100000;
        for (int i = 0; i < iterations; i++) {
            double f = generateRandomValue2(intervals);
            for (int j = 1; j <= 5; j++)
                if (f >= j - 1 && f < j) {
                    count[j - 1]++;
                }
        }

        for (int j = 1; j <= 5; j++) {
            System.out.println("Ex1: Interval [" + (j - 1) + "," + j + ") with probability " + 100 * (double) count[j - 1] / iterations + " %");
        }
        System.out.println();

        intervals = new Interval[]{
                new Interval(1, 3),
                new Interval(2, 5),
                new Interval(1, 4),
                new Interval(0, 2)
        };

        count = new int[5];
        for (int i = 0; i < iterations; i++) {
            double f = generateRandomValue2(intervals);
            for (int j = 1; j <= 5; j++)
                if (f >= j - 1 && f < j) {
                    count[j - 1]++;
                }
        }

        for (int j = 1; j <= 5; j++) {
            System.out.println("Ex2: Interval [" + (j - 1) + "," + j + ") with probability " + 100 * (double) count[j - 1] / iterations + " %");
        }
        // Interval [0,1) with probability ~10%
        // Interval [1,2) with probability ~30%
        // Interval [2,3) with probability ~30%
        // Interval [3,4) with probability ~20%
        // Interval [4,5) with probability ~10%
    }

    // time complexity: worst is O(n), used for while loop
    // space complexity: O(1)
    public static double generateRandomValue2(Interval[] intervals) {
        double flat = 0;
        for (Interval interval : intervals) {
            flat += interval.length();
        }
        double pos = flat * Math.random();
        int i = 0;
        Interval currentInterval = intervals[i];
        while (pos > currentInterval.length()) {
            pos = pos - (currentInterval.length());
            currentInterval = intervals[++i];
        }
        return intervals[i].low + pos;
    }

    static class Interval {
        double low;
        double high;

        public Interval(double low, double high) {
            this.low = low;
            this.high = high;
        }

        double length() {
            return high - low;
        }
    }
}