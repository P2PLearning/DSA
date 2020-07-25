import collections
def main():
    chars = [e for e in "hello world"]
    print(removeDuplicateCharacter(chars))
def removeDuplicateCharacter(s):
    #HashMap: O(N) amortized time, O(|A|) space where |A| is size of the alphabet.
    #If the alphabet is known (e.g. ASCII characters, UTF-8, etc), then it can be regarded as O(1) space
    d = {}
    res = []
    for i, e in enumerate(s):
        if d.get(e, 0) == 0:
            res.append(e)
            d[e] = 1
    return res
    #built-in function: O(N) time, O(|A|) space, 2 passes
    # res = []
    # c = collections.Counter(s)
    # for i, e in enumerate(s):
    #     if c[e] > 0:
    #         res.append(e)
    #         c[e] = 0
    # return res
        
main()