------------------------------------
Highlights
------------------------------------
Some people are confused of input size (N) vs tree height (H) in time and space complexity:
 - Time: O(H) - H is tree height
   - O(logN) assuming balance binary tree; if tree fanout is K, it should be O(log(K, N))
 - Space: O(1) - if you got the optimal solution
   - If you use a HashMap from e to root, it should be O(H)

Non-optimal recursion solution from [Thao](https://github.com/P2PLearning/DSA/pull/41/commits/19cf3a30b5da8aedb7020f67daed06a8530813c8). Can you come up with space and time complexity for her algorithm?

------------------------------------
Tips
------------------------------------
1. when to use `while` and when to use `for`:
```
    while (e1 != e2) {
      e1 = boss[e1];
      e2 = boss[e2];
    }
    return e1;
```
vs 
  ```
      if(e1==e2) return e1;
      for(i =0; i<a1;i++){
        for(int j=0; j<a2;j++){
        if(l1[i]==l2[j]){ return l1[i];}
      }
      return l1[i];
```

2. We know that input values are valid.
```
if e1 != -1
```
vs
```
if 0 <= e1 <= len(boss) - 1:
```

------------------------------------
Bugs
------------------------------------
