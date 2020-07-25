package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubstringOfAllCharacters {
    public static void main(String[] args) {
        System.out.println(getShortestSubstringOfAllCharacters("xyyzyzxy", "xyz"));  // "zxy"
    }

    static String getShortestSubstringOfAllCharacters(String arr, String str) {

        // Edge cases
        if (arr.isEmpty() || str.isEmpty()) {
            return "";
        }

        Map<Character, Integer> targetStr = new HashMap<>();

        // Create hash map of target str to find on S
        for (int i = 0; i < str.length(); i++) {
            if (!targetStr.containsKey(str.charAt(i))) {
                targetStr.put(str.charAt(i), 0);
            } else {
                int count = targetStr.get(str.charAt(i));
                targetStr.put(str.charAt(i), ++count);
            }
        }

        Map<Character, Integer> findSubSrt = new HashMap<>();
        int startW = 0;
        int endW = 0;

        while (endW < arr.length()) {
            Character currentChar = arr.charAt(endW);

            if (targetStr.containsKey(currentChar) && !findSubSrt.containsKey(currentChar)) {
                findSubSrt.put(currentChar, 0);
            } else if(findSubSrt.containsKey(currentChar)) {
                startW = endW;
                findSubSrt.clear();
            }
            endW++;
        }

        return arr.substring(startW, endW);
    }
}
