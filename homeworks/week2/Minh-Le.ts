//Repl url for testing: https://repl.it/join/svpniinp-minhd1

class Main {
  static test(input: string[] | null, expected: string | null) {
    if (input === null && expected === null) {
      console.log("null passed");
      return;
    } else if (input === null) {
      throw new Error("Expected null to be null");
    }
    const inputClone = [...input];
    Main.removeDuplicateCharacters2(input);
    if (input.join("") !== expected) {
      throw new Error(
        `Expected result to be "${expected}" instead of "${input.join('')}"`
      );
    }
    console.log(`Input "${inputClone.join("")}" passed. Expected: "${expected}"`);
  }
  static main(args?: string[]) {
    const expectedMap = new Map<string[] | null, string | null>();
    expectedMap.set("hello world".split(""), "helo wrd");
    expectedMap.set(null, null);
    expectedMap.set("ssss".split(""), "s");
    expectedMap.set("some other tests".split(""), "some thr");
    expectedMap.set("with    extra spaces".split(""), "with exraspc");

    expectedMap.forEach((expected, input) => {
      try {
        Main.test(input, expected);
      } catch (e) {
        console.log(e);
      }
    });

    // Output: "helo wrd"
  }

  // Please comment on approaches you are taking, and their space and time complexity.
  // If time is allowed, you can provide multiple versions of the method with trade-off in space and time complexity.

  // Time complexity of the method below: O(n), space complexity O(1)
  // since the size of map variable is upper-bounded by the number of possible characters
  static removeDuplicateCharacters(s: string[] | null): void {
    if (s === null) return;
    const map: { [key: string]: number } = {};
    for (let i = 0; i < s.length; i++) {
      if (map[s[i]] === undefined) {
        map[s[i]] = i; // store index of first-occurence letters into the map
      }
    }

    // remove duplicated character by indexes from the end
    for (let i = s.length - 1; i >= 0; i--) {
      if (i !== map[s[i]]) {
        // check if the current index is the first-occurence index of the letter
        s.splice(i, 1);
      }
    }
  }

  // This method use for loop instead of splice to remove character 
  // from array which has the same time complexity

  // Time complexity of the method below: O(n), space complexity O(1)
  // since the size of map variable is upper-bounded by the number of possible characters
  static removeDuplicateCharacters2(s: string[] | null): void {
    if (s === null) return;
    const map: { [key: string]: number } = {};
    for (let i = 0; i < s.length; i++) {
      if (map[s[i]] === undefined) {
        map[s[i]] = i; // store index of first-occurence letters into the map
      }
    }

    // remove duplicated character by indexes from the end
    for (let i = s.length - 1; i >= 0; i--) {
      if (i !== map[s[i]]) {
        //delete s[i] by shifting the array backward from i+1 position
        for(let j = i; j<s.length-1; j++) {
          s[j] = s[j+1];
        }
        s.length--; //change length property
      }
    }
  }
}

Main.main();
