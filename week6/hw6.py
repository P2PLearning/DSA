from collections import Counter
def getShortestSubstrOfAllChar(S, T):
    '''get shortest substring of all char. If there are multiple substrings with same length, return the leftmost one.

    Time Complexity: O(max(N, M)) where N = length of S and M = length of T (in case O(N) < O(M) the time complexity is strictly O(N), it does not depend on the size of the alphabet |A|).

    Auxiliary Space: O(|A|) where |A| = the number of different characters in T'''
    #first, build a set of all chars in T
    setT = set(T)
    #Two pointers at the ends of the substring
    i, j = 0, 0
    #A HashMap (key, val) where key = character, val = frequency
    d = {}
    #Keep track of current optima
    optval, opt = float('inf'), None
    while i < len(S) and j < len(S):
        while j < len(S) and len(d) < len(setT): #not enough
            if S[j] in setT: #only care if S[j] is in T
                d[S[j]] = d.get(S[j], 0) + 1
            j += 1
        while i < len(S) and len(d) == len(setT):
            if optval > j - i + 1:
                optval = j - i + 1
                opt = (i, j)
            if S[i] in setT: #only care if S[j] is in T
                d[S[i]] -= 1
                if d[S[i]] == 0:
                    del d[S[i]]
            i += 1
        while i > j:
            j += 1
    if not opt:
        res = -1
    else:
        res = S[opt[0]: opt[1]]
    print(res)
    return res
def main():
    getShortestSubstrOfAllChar("xyyzyzyx", "xyz") #zyx
    getShortestSubstrOfAllChar("xyyzyzyx", "xy") #xy
    getShortestSubstrOfAllChar("xyyzyzyx", "xyzt") #-1: No window found!
    getShortestSubstrOfAllChar("xyyzyzyx", "z") #z
    getShortestSubstrOfAllChar("xyyzyzyyx", "xyz") #xyyz
    getShortestSubstrOfAllChar("abc", "x") #-1
    getShortestSubstrOfAllChar("aaaaaaa", "aaaaa") #a
    getShortestSubstrOfAllChar("aaaaaaaccccccb", "ab") #accccccb
    getShortestSubstrOfAllChar("aaaaaaa@!", "a!t") #-1
    getShortestSubstrOfAllChar("t   aaaaaaa@@! z", "a!t") #t   aaaaaaa@@!
main()