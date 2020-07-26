//repl: https://repl.it/@MinhD1/minimumSubstring#index.ts

class Main {
    static test() {
      console.log(Main.getShortestSubstringOfAllCharacters('xyyzyzyx', 'xyz')); //zyx
  
      console.log(Main.getShortestSubstringOfAllCharacters('jzyfgyzxuzyyuuuxz', 'xyyzz')); // yzxuzy
  
      console.log(Main.getShortestSubstringOfAllCharacters('a', 'a')); // a
  
      console.log(Main.getShortestSubstringOfAllCharacters('fgzyyxdgsh', 'xyyzz')); // ''
  
      console.log(Main.getShortestSubstringOfAllCharacters('zfgyyxdgshz', 'xyyzz')); // 'zfgyyxdgshz'
    }
  
    static getShortestSubstringOfAllCharacters(arr: string, str: string): string {
      // create a map from str that store unique characters and their count
      const dictStr = new Map<string, number>();
  
      for (const char of str) {
        dictStr.set(char, (dictStr.get(char) || 0) + 1);
      }
  
      const requiredSize: number = dictStr.size;
      let left = 0;
      let right = 0;
  
      const answer: {
        left: number;
        length: number | undefined;
        right: number;
      } = {
        length: undefined,
        right: 0,
        left: 0,
      };
      // A Map that store characters that exist in str and their respective count in current window
      const currentWindowMap = new Map();
  
      // track the count of the characters in str which has enough count in current window,
      // by comparing this variable and requiredSize, we can figure out if current window satisfies the condition
      let currentCharacterCount = 0;
      while (right < arr.length) {
        // since the minimum window should have beginning and ending character that both exist in str,
        // we only care about those characters
        if (!dictStr.has(arr[right])) {
          right++;
          continue;
        }
  
        currentWindowMap.set(arr[right], (currentWindowMap.get(arr[right]) || 0) + 1);
        if (currentWindowMap.get(arr[right]) === dictStr.get(arr[right])) {
          currentCharacterCount++;
        }
  
        // move the left pointer by one position as long as current window satisfy the condition
        while (left <= right && currentCharacterCount === requiredSize) {
          // since the minimum window should have beginning and ending character both exist in t,
          // we only care about those characters
          if (!dictStr.has(arr[left])) {
            left++;
            continue;
          }
          // decrease the count of this character since it will be out of the window after this iteration
          currentWindowMap.set(arr[left], (currentWindowMap.get(arr[left]) || 0) - 1);
  
          // decrease currentWindowMap if current character's count in current window less than required count
          if (currentWindowMap.get(arr[left])! < dictStr.get(arr[left])!) {
            currentCharacterCount--;
          }
  
          // compare length of previous answer and replace if shorter length found
          if (answer.length === undefined || right - left + 1 < answer.length) {
            answer.length = right - left + 1;
            answer.right = right;
            answer.left = left;
          }
  
          left++;
        }
  
        right++;
      }
  
      if (answer.length) {
        return arr.slice(answer.left, answer.right + 1);
      }
  
      return '';
    }
  }
  
  Main.test();
  