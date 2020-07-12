// Given a list of intervals [low, high) where low < high and len(intervals) >= 1, uniformly randomly generate a point from the union of these intervals.
// For example, given intervals [2,5], [1,3], method generateRandomValue produces a random value in [1, 2) with 20%, [2,3) with 40%, and [3,5) with 40%.

import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Interval[] intervals = {
      new Interval(1,3),
      new Interval(2,5),
      new Interval(1,4),
      new Interval(0,2)
    };

    int[] count = new int[5];
    int iterations = 1000;
    //int iterations = 1;
    for (int i = 0; i < iterations; i++) {
      double f = generateRandomValue(intervals);
      for (int j = 1; j <= 5; j++)
      if (f >= j-1 && f < j) {
        count[j-1] ++;
      }
    }

    for (int j = 1; j <= 5; j++) {
      System.out.println("Interval [" + (j-1) + "," + j + ") with probability " + 100*(double)count[j-1]/iterations + " %");
    }
    // Interval [0,1) with probability ~10%
    // Interval [1,2) with probability ~30%
    // Interval [2,3) with probability ~30%
    // Interval [3,4) with probability ~20%
    // Interval [4,5) with probability ~10%
  }  
  
  public static double generateRandomValue(Interval[] intervals) {

    //Edge case concerning the list of intervals
    if ((intervals== null)||(intervals.length==0))
    return 0;

    //Each checkpoint is either the low or high value of an interval
    Set<Double> setOfCheckpoints = new HashSet<>();

    //I think add() is O(1) in time complexity
    for (int i=0; i<intervals.length; i++)
    {      
      setOfCheckpoints.add(intervals[i].low);
      setOfCheckpoints.add(intervals[i].high);
    }    
   
    List<Double> sortedListOfCheckpoint = new ArrayList<>(setOfCheckpoints);
    Collections.sort(sortedListOfCheckpoint);
    //System.out.println("Sorted list of checkpoint is " + sortedListOfCheckpoint.toString());

    //This array stores the frequency count of each segment
    int[] frequencyCount = new int[sortedListOfCheckpoint.size()-1];    
    for (int i=0; i < frequencyCount.length; i++)
    frequencyCount[i] = 0;

    //This sum of all frequency count is at most n*n
    int totalFrequency = 0;

    //Counting the frequency of each segment
    for (int i=0; i < sortedListOfCheckpoint.size()-1; i++)
    {
      for (int j=0; j<intervals.length; j++)
      {
        //A segment is represented by its middle point
        double midSegment = (sortedListOfCheckpoint.get(i)+sortedListOfCheckpoint.get(i+1))/2;

        if (intervals[j].contains(midSegment))
        {
          frequencyCount[i]++;
          totalFrequency++;
        }
          
      }
    }

    //System.out.println(Arrays.toString(frequencyCount) + " total frequency " + totalFrequency);

    //Generating random numbers for each segment. 
    int index = 0;
    double[] randomNumberArray = new double[totalFrequency];
    for (int i=0; i< frequencyCount.length; i++)
    {
      for (int j=0; j < frequencyCount[i]; j++)
      {
        double leftLimit = sortedListOfCheckpoint.get(i);
        double rightLimit = sortedListOfCheckpoint.get(i+1);
        randomNumberArray[index] = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);
        index++;
      }
    }

    //System.out.println(Arrays.toString(randomNumberArray));

    int minIndex = 0;
    int maxIndex = totalFrequency;
    int indexOfRandomNumber = minIndex + new Random().nextInt(maxIndex-minIndex);

    System.out.println("Random index is " + indexOfRandomNumber);
    System.out.println("Random number is " + randomNumberArray[indexOfRandomNumber]);

    //Randomly select a number among the generated numbers
    return randomNumberArray[indexOfRandomNumber];

  }

  static class Interval {
    double low;
    double high;
   
    public Interval(double low, double high) {
      this.low = low;
      this.high = high;
    }

    public boolean contains(double val)
    {
      if ((val<low)||(val>high)) return false;
      else return true;
    }

    double length() {
      return high - low;
    }
  }

}
