#!/usr/bin/env python3

# Time complexity: O(n):
# - we iterate through the input string/array once
# - look up to a checked hash once
# - and append to the result array (the size of array is capped at string encoding size), we can improve this to use a link list
#   which has a O(1) for add an item to it
# Space complexity: O(1): the data structure we create is:
# - a result string (it is capped at string encoding standard size)
# - a hashmap collection of visited characters (capped at string encodinng size as well)
def removeDuplicateCharacters(inputVal):
    if inputVal is None:
        return ""

    uniqChars = {}
    ans = []
    for ch in inputVal:
        if ch not in uniqChars:
            ans.append(ch)
            uniqChars[ch] = True
    return ''.join(ans)

testCases = [
    {
        "input": ['h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'],
        "output": "helo wrd",
    },
    {
        "input": "hello world",
        "output": "helo wrd",
    },
    {
        "input": "hello !!!@@@###$$$ 9900112233",
        "output": "helo !@#$90123",
    },
    {
        "input": "aaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccc",
        "output": "abc",
    },
    {
        "input": "This is a sentense to test the program",
        "output": "This aentoprgm",
    },
    {
        "input": [],
        "output": "",
    },
    {
        "input": None,
        "output": "",
    },
]
for test in testCases:
    output = removeDuplicateCharacters(test["input"])
    # print (output, test["output"])
    assert(test["output"] == output)
    print(output)

