class Main {
    public static void main(String[] args) {
        removeDuplicateCharacters("Hello world!".toCharArray());
        removeDuplicateCharacters("Hi!".toCharArray());
        removeDuplicateCharacters("H".toCharArray());
        removeDuplicateCharacters("aaaaaaaaaaaaaaaaa".toCharArray());
        removeDuplicateCharacters("test  case  ".toCharArray());
        removeDuplicateCharacters("This is a sentense to test the program".toCharArray());
        removeDuplicateCharacters("".toCharArray());
        removeDuplicateCharacters(null);
    }

    // Time complexity is O(n)
    // Space complexity is O(n) as we use an extra space for StringBuffer
    public static void removeDuplicateCharacters(char[] str) {
        if (str != null) {
            // This array will let the program know that which
            // character was used
            boolean[] asciiTable = new boolean[256];
            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < str.length; i++) {
                if (!asciiTable[str[i]]) {
                    sb.append(str[i]);
                    asciiTable[str[i]] = true;
                }
            }

            System.out.println(sb.toString());
        }
    }
}
