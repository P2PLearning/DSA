package com.dsa;

import java.util.Random;

public class GenerateRandomValue {

    // 0   2       //
    //   1   3     //
    //   1     4   //
    //     2     5 //
    // => LOW < low,high < HIGH => overlap
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
            System.out.println("Interval [" + (j - 1) + "," + j + ") with probability " + 100 * (double) count[j - 1] / iterations + " %");
        }
        // Interval [0,1) with probability ~10%
        // Interval [1,2) with probability ~30%
        // Interval [2,3) with probability ~30%
        // Interval [3,4) with probability ~20%
        // Interval [4,5) with probability ~10%
    }

    // Brute force approach:
    // Don't forget to comment on space and time complexity.
    // Time complexity for this is O(3n square) = O(n square)
    // Space complexity is O(n + 100) = O(n)
    public static double generateRandomValue(Interval[] intervals) {
        Random rand = new Random();
        int maxLength = getTotalLength(intervals); // O(n)
        int[] frequency = calculateIntervalFrequency(intervals, maxLength); // O(n square)
        int[] distributedNumbers = createDistributedArray(frequency, maxLength); // O(n square)

        return distributedNumbers[rand.nextInt(100)] + rand.nextDouble();
    }

    // Time complexity for this is O(n square)
    // Space complexity is O(n)
    public static int[] calculateIntervalFrequency(Interval[] intervals, int maxLength) {
        int[] results = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            Interval currentItv = new Interval(i, i + 1);

            // => GivenInterval.LOW < low,high < GivenInterval.HIGH => overlap
            for (Interval itv : intervals) {
                if ((itv.low < currentItv.low && currentItv.low < itv.high)
                        || itv.low < currentItv.high && currentItv.high < itv.high) {
                    results[i]++;
                }
            }
        }

        return results;
    }

    // Time complexity for this is O(2n square)
    // Space complexity is O(100) = O(1)
    public static int[] createDistributedArray(int[] frequency, int maxLength) {
        int[] results = new int[100];
        int end = 0;
        int start;
        int totalFred = calculateTotalFreq(frequency);
        int perFredPercent = Math.round(1f / (totalFred / 100f));

        for (int i = 0; i < maxLength; i++) {
            start = end;
            end = start + frequency[i] * perFredPercent;
            for (int j = start; j < end; j++) {
                results[j] = i;
            }
        }

        return results;
    }

    // Time complexity for this is O(n)
    // Space complexity is O(1)
    public static int calculateTotalFreq(int[] frequency) {
        int sum = 0;

        for (int freq : frequency) {
            sum += freq;
        }

        return sum;
    }

    // Time complexity for this is O(n)
    // Space complexity is O(1)
    public static int getTotalLength(Interval[] intervals) {
        Interval totalInterval = new Interval(intervals[0].low, intervals[0].high);

        for (Interval itv : intervals) {
            if (totalInterval.high < itv.high) {
                totalInterval.high = itv.high;
            }

            if (totalInterval.low > itv.low) {
                totalInterval.low = itv.low;
            }
        }

        return (int) totalInterval.length();
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