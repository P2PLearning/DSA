import java.util.Arrays;
// Given a list of intervals [low, high) where low < high and len(intervals) >= 1, uniformly randomly generate a point from the union of these intervals.
// For example, given intervals [2,5], [1,3], method generateRandomValue produces a random value in [1, 2) with 20%, [2,3) with 40%, and [3,5) with 40%.

// Clarify: In my opinion, if I uniformly generate numbers from each interval and add them up, I will get the correct solution without sorting.
// For example, there is 2 intervals [1,3] and [2,4]. If I generate 1000 numbers uniformly from the first interval, there should be 500 numbers in
// the [2,3]. The same thing happens in the second interval and I will get 500 numbers in [1,2], 500 numbers in [2,3] (1st interval) plus 500 number
// [2,3] (2nd interval) and the last 500 numbers in [3,4]. Thus, naturally, I will get the result where [2,3] has double the prob.
// I wrote the oldGenerateRandomValue to point out that I got the pretty correct output without using any sorting algorithms.
// Thus, I went to Mr. Tuan Anh's explanation last Sunday that I need to union the intervals then uniformly generate number from those new intervals.

import java.util.Random;

class Main {
    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(1,3),
                new Interval(2,5),
                new Interval(1,4),
                new Interval(0,2),
        }; //Intervals union into 1 interval [0,5]

        Interval[] intervals2 = {
                new Interval(1,2),
                new Interval(3,4),
                new Interval(5,6),
                new Interval(7,8)
        }; //Intervals are separated [1,2] U [3,4] U [5,6] U [7,8] with equal length

        Interval[] intervals3 = {
                new Interval(1,3),
                new Interval(2,5),
                new Interval(1,4),
                new Interval(6,8),
        }; //Hybrid [1,5] U [6,8]

        Interval[] intervals4 = {
                new Interval(0,1),
                new Interval(3,9),
                new Interval(10, 13)
        }; //Separated with different length [0,1] U [3,9] U [10,13]

        Interval[] originalTest = {
                new Interval(2,5),
                new Interval(1,3)
        };
        test(intervals);
        System.out.println("========");
        test(originalTest);
        System.out.println("========");

        // Test for generateRandomValue function only.

        //test(intervals2);
        //System.out.println("========");
        //test(intervals3);
        //System.out.println("========");
        //test(intervals4);

    }

    public static void test(Interval[] intervals){
        double low = Integer.MAX_VALUE;
        double high = Integer.MIN_VALUE;
        for(Interval interval : intervals){
            if(interval.low < low)
                low = interval.low;
            if(interval.high > high)
                high = interval.high;
        }
        int length = (int)(high-low);
        int[] count = new int[length];
        int iterations = 100000;
        for (int i = 0; i < iterations; i++) {
            // Implemented from Mr Tuan Anh's explanation

            //double f = generateRandomValue(intervals);

            // Implemented from Mr Hien's explanation

            double f = oldGenerateRandomValue(intervals);

            for (int j = 0; j < length; j++) {
                if (f >= (j + low) && f < (j + low + 1)) {
                    count[j]++;
                }
            }
        }

        for (int j = 0; j < length; j++) {
            double prob = 100*(double)count[j]/iterations;
            if (prob > 0)
                System.out.println("Interval [" + (int)(j + low) + "," + (int)(j + low + 1) + ") with probability " + prob + " %");
        }
    }
    public static double oldGenerateRandomValue(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return -1;
        Random rnd = new Random();
        double rndNumber = rnd.nextDouble(); // Uniformly generate a number
        double firstRange = 0;
        double span = 0;
        for (Interval interval : intervals) // O(n) Time
            span += interval.length();
        for (Interval interval : intervals){ // O(n) Time
            if(rndNumber >= firstRange/span && rndNumber < (firstRange+interval.length())/span){
                return rndNumber*span - (firstRange - interval.low);
            }
            firstRange += interval.length();
        }
        return -1;
    }
    // Time Complexity: O(2kn) with k is sample times. It can be reduced to O(kn) + O(n) if taking the loop to calculate span outside the function.
    // Space Complexity: O(1)

    public static double generateRandomValue(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return -1;

        //Union intervals
        Arrays.sort(intervals, (i1, i2) -> Double.compare(i1.low, i2.low)); //Sort intervals, O(nlogn) Time
        int count = 0; // O(1) Space
        double low = intervals[0].low; // O(1) Space
        double high = intervals[0].high; // O(1) Space
        double span = 0; // O(1) Space
        for(int i = 1; i < intervals.length; i++){ // O(n) Time
            if(intervals[i].low > high){ //If new interval is separated
                intervals[count] = new Interval(low, high);     // Initially, I used an ArrayList to store new interval.
                                                                // But to reduce the space complexity, the new interval is placed on the input array
                                                                // And count variable stores the length in new intervals (i.e the old ArrayList.size())
                count++;
                span += high - low;
                low = intervals[i].low;
                high = intervals[i].high;
            }
            else{
                high = Math.max(intervals[i].high, high);
            }
        }
        intervals[count] = new Interval(low, high); // Add the last union interval to list
        span += high - low;
        count++;
        //Generate number: Uniformly generate a random number in range [0,1]. Mapping this number to proper range.
        Random rnd = new Random();
        double rndNumber = rnd.nextDouble(); // Uniformly generate a number in [0,1)
        double firstRange = 0; // O(1) Space
        for(int i = 0; i < count; i++){ // O(n) Time
            if(rndNumber >= firstRange/span && rndNumber < (firstRange+intervals[i].length())/span){
                return rndNumber*span + intervals[i].low - firstRange; // Mapping. To illustrate, please visit this link: https://imgur.com/a/Kp4czDq
            }
            firstRange += intervals[i].length();
        }
        return -1;
    }
    //Time Complexity: O(knlogn)
    //Space Complexity O(1)


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
