package com.Hiento.session2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        s = removeDuplicateCharacters(s);
        // s = {'h', 'e', 'l', 'o', ' ', 'w', 'r', 'l', 'd'};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        // Output: "helo wrd"
    }

    // Please comment on approaches you are taking, and their space and time complexity.
    // If time is allowed, you can provide multiple versions of the method with trade-off in space and time complexity.
    public static char[] removeDuplicateCharacters(char[] s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : s) {
            if (seen.contains(c)) continue;
            seen.add(c);
            sb.append(c);
        }
        return sb.toString().toCharArray();
    }
   }
