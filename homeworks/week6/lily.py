from collections import Counter
S = "xyyzyzyx"
T = "xyz"

def minWindow(s, t):
    counter = Counter(t)
    min_len = float('inf')
    min_s = ""
    l = 0
    for r, r_char in enumerate(s):
        counter[r_char] -= 1
        while is_substring(counter):
            cur_len = r - l + 1
            if cur_len < min_len:
                min_len, min_s = cur_len, s[l:r+1]
            if s[l] in counter:
                counter[s[l]] += 1
            l += 1
    return min_s

def is_substring(dic):
    for k, v in dic.items():
        if v > 0:
            return False
    return True

print(minWindow(S, T))

 # Time complexity: 0(nXm)
 # Space complexity 0(m)

