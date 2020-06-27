------------------------------------
Highlights
------------------------------------
+ Remember to include space and time complexity!!!
  + The easiest way to estimate time complexity is to count the number of nested loops. In more complicated cases, especially in recursive algorithms, you can write a few examples with increasing input sizes, then walk through them manually until you find a pattern. (Of course, it'd be the best if you can prove time complexity mathematically.)
  + Beware of the cost to delete/insert elements in an array. It's O(n) not O(1). 
+ Use an additional data structure (StringBuffer, List) to store unique characters. One says O(1) but other says O(N)
  + Which one is more accurate? By default, average case (and worst case) is used, which is O(N) here. But the best case would be O(1)
+ Add tests after your interview is equally important as writing code
  + Tin has a really nice set of test cases https://github.com/P2PLearning/DSA/pull/3#pullrequestreview-438724864
+ In an interview, you cannot change the method signature without an agreement from w/ the interviewer
------------------------------------
Tips
------------------------------------
+ The first way is preferred
```
if (str == null) return;
// The rest of the code
```
And
```
if (str != null) {

}
```

+ Follow a standard indentation for your code https://google.github.io/styleguide/javaguide.html
------------------------------------
Bugs
------------------------------------
