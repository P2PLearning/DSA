public class Main {
    public static void main(String[] args) {
        Interval[] intervals = {
        		new Interval(1, 3),
                new Interval(2, 5),
                new Interval(1, 4),
                new Interval(0, 2)
        };

        int[] count = new int[5];
        int iterations = 100000;
        for (int i = 0; i < iterations; i++) {
            double f = generateRandomValue(intervals);
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

    
    //Time complexity O(n)
    //Space complexity O(1)
    //This is not my own work, because I could not think of the solution, so I learned and understand from other's  solution.
    
    public static double generateRandomValue(Interval[] intervals) {
        double len = 0;
        
        for (Interval interval : intervals) {
            len += interval.length();
        }
        double value = len * Math.random();
        int i = 0;
        Interval currentInterval = intervals[i];
        
        
        while (value > currentInterval.length()) {
            value = value - (currentInterval.length());
            i++;
            currentInterval = intervals[i];
        }
        return intervals[i].low + value;
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