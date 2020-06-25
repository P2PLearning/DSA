//Repl url for testing: https://repl.it/join/svpniinp-minhd1

class Main {
  static main(args: string[]) {
    const s: string[] = ["h", "e", "l", "l", "o", " ", "w", "o", "r", "l", "d"];
    Main.removeDuplicateCharacters(s);
    // s = ['h', 'e', 'l', 'o', ' ', 'w', 'r', 'd'];
    console.log(s.join(""));
    // Output: "helo wrd"
  }

  // Please comment on approaches you are taking, and their space and time complexity.
  // If time is allowed, you can provide multiple versions of the method with trade-off in space and time complexity.
  
  // Time complexity of the method below: O(n), space complexity O(1) 
  // since the size of map variable is upper-bounded by the number of possible characters 
  static removeDuplicateCharacters(s: string[]): void {
    const map = {};
    for (let i = 0; i < s.length; i++) {
      if (!map[s[i]]) {
        map[s[i]] = i // store index of first-occurence letters into the map
      }
    }

    // remove duplicated character by indexes from the end
    for (let i = s.length - 1; i >= 0; i--) {
      if (i !== map[s[i]]) { // check if the current index is the first-occurence index of the letter
        s.splice(i, 1);
      }
    }
  }
}
