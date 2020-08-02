package homeworks.week6;

// Given a string S and a string T,
// find the minimum window in S which will contain all the characters in T
// Input: S = "xyyzyzyx" T = "xyz”
// Output: "zyx"


import java.util.HashSet;
import java.util.Set;

public class VuNguyen {
    public static void main(String[] args) {
        System.out.println(getShortestSubstringOfAllCharacters("xyyzyzyx", "xyz"));
        // "zyx"

        System.out.println(getShortestSubstringOfAllCharacters("xyxz", "xyz"));
        // "yxz"
        System.out.println(getShortestSubstringOfAllCharacters("xyz", "xyz"));
        // "xyz"
        System.out.println(getShortestSubstringOfAllCharacters("xyz", "y"));
        // y
        System.out.println(getShortestSubstringOfAllCharacters("xyz", "z"));
        // z
    }

    // assume arr alway contain all the characters in T for sure
    // assume T alway contain distinct character
    // time complexity: O(n)
    // space complexity: O(n) for set
    static String getShortestSubstringOfAllCharacters(String arr, String T) {
        if (T.length() == 0) return "";
        Set<Character> set = resetSetT(T);
        String ans = arr;
        int start = 0;
        for (int i = 0; i < arr.length(); i++) {
            set.remove(arr.charAt(i));
            if (set.isEmpty()) {
                if (ans.length() > i + 1 - start) {
                    ans = arr.substring(start, i + 1);
                }
                start = i;
                set = resetSetT(T);
                set.remove(arr.charAt(i));
                if (set.isEmpty()) ans = arr.substring(i, i + 1);

            }
        }
        set = resetSetT(T);
        int end = arr.length() - 1;
        for (int i = arr.length() - 1; i >= 0; i--) {
            set.remove(arr.charAt(i));
            if (set.isEmpty()) {
                if (ans.length() > end + 1 - i) {
                    ans = arr.substring(i, end + 1);
                }
                end = i + 1;
                set = resetSetT(T);
                set.remove(arr.charAt(i));
                if (set.isEmpty()) ans = arr.substring(i, i + 1);
            }
        }
        return ans;
    }

    private static Set<Character> resetSetT(String str) {
        Set<Character> set = new HashSet<>();
        for (Character ch : str.toCharArray()) {
            set.add(ch);
        }
        return set;
    }
}
