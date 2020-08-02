 
 class trang_vu6{
  public static void main(String[] args) {
    System.out.println(getShortestSubstringOfAllCharacters("xyyzyzyx", "xyz"));  // "zyx"
  }

  // Time complexity O(n)
  // Space complexity O(n)
 static String getShortestSubstringOfAllCharacters(String str, String pat) 
    { 
        int len1 = str.length(); 
        int len2 = pat.length(); 
      
        if (len1 < len2) 
        { 
            System.out.println("No such window exists"); 
            return ""; 
        } 
      
        int pattern[] = new int[256]; 
        int string[] = new int[256]; 
      
        for (int i = 0; i < len2; i++) 
            pattern[pat.charAt(i)]++; 
      
        int start = 0, start_index = -1, min_len = Integer.MAX_VALUE; 
      
        
        int count = 0;
        for (int j = 0; j < len1 ; j++) 
        { 
            string[str.charAt(j)]++; 
            if (pattern[str.charAt(j)] != 0 && 
                string[str.charAt(j)] <= pattern[str.charAt(j)] ) 
                count++; 
      
            if (count == len2) 
            { 
            
                while ( string[str.charAt(start)] > pattern[str.charAt(start)] 
                    || pattern[str.charAt(start)] == 0) 
                { 
      
                    if (string[str.charAt(start)] > pattern[str.charAt(start)]) 
                        string[str.charAt(start)]--; 
                    start++; 
                } 
      
                int len_window = j - start + 1; 
                if (min_len > len_window) 
                { 
                    min_len = len_window; 
                    start_index = start; 
                } 
            } 
        } 
       
        if (start_index == -1) 
        { 
        System.out.println("No such window exists"); 
        return ""; 
        } 
        return str.substring(start_index, start_index + min_len); 
    } 
 }
