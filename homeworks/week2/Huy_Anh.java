import java.util.*;

class Main {
    public static void main(String[] args) {
        System.out.println(unorderedRemoveDuplicate(null)); //null
        System.out.println(orderedRemoveDuplicate(null)); //null
        System.out.println(unorderedRemoveDuplicate("")); //blank
        System.out.println(orderedRemoveDuplicate("")); //blank
        System.out.println(unorderedRemoveDuplicate("doonneeee")); //deno
        System.out.println(orderedRemoveDuplicate("doonneeee")); //done
        System.out.println(unorderedRemoveDuplicate("paragraphs")); //aghprs
        System.out.println(orderedRemoveDuplicate("paragraphs")); //parghs
        System.out.println(unorderedRemoveDuplicate("yay!!@#@'")); //!#'@ay
        System.out.println(orderedRemoveDuplicate("yay!!@#@'")); //ya!@#'
        System.out.println(unorderedRemoveDuplicate("hello world!")); // !dehlorw
        System.out.println(orderedRemoveDuplicate("hello world!")); //helo wrd!
    }

    public static String orderedRemoveDuplicate(String inputString) {
        //Create a hashtable that has all alphabet letters and numbers as keys and 0 as value
        if (inputString == null) return inputString;
        char[] AlphabetWithDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~', ' '};
        Hashtable<Character, Integer> storeTable = new Hashtable<Character, Integer>();
        for (Character alphabetWithDigit : AlphabetWithDigits) {
            storeTable.put(alphabetWithDigit, 0);
        }
        StringBuilder outputStr = new StringBuilder();
        for (int i = 0; i < inputString.length(); i++) {
            if (storeTable.get(inputString.charAt(i)) == 0) { //If a char that has value of 0, then that char is not duplicated yet, append it into StringBuilder
                outputStr.append(inputString.charAt(i));
                storeTable.replace(inputString.charAt(i), 1); //then change value of that char to 1, so it will not be appended into StringBuilder anymore.
            }
        }
        return outputStr.toString();
    }
    //Time Complexity: O(n) <- Because the function contains only one for loop over the string.
    //Space Complexity: O(1) <- Normally, StringBuilder takes O(n) memory. However, since it only stores the unique character, string's length is bounded (2^16 number of elements if using UTF-16 encoding)
    //Same as hashtable has fixed number of elements.

    public static String unorderedRemoveDuplicate(String inputString) {
        //Sort -> Remove duplicate
        if (inputString != null && !inputString.isEmpty()) {
            char[] charArray = inputString.toCharArray(); //Takes O(n) space complexity
            Arrays.sort(charArray); //This method uses dual-pivot QuickSort, thus it has O(nlogn) time complexity
            StringBuilder outputStr = new StringBuilder(); //O(constant) space complexity
            for (int i = 0; i < charArray.length - 1; i++) { //This loop takes O(n) time complexity
                if (charArray[i] != charArray[i + 1]) { //Scan through the array, if two consecutive elements has different value -> append charArray[i] into StringBuilder
                    outputStr.append(charArray[i]);
                }
            }
            outputStr.append(charArray[charArray.length - 1]); //Append the last element since it doesn't meet the if condition above
            return outputStr.toString();
        }
        return inputString;
    }
    //Time Complexity: O(n)
    //Space Complexity: O(1)
}