def removeDuplicateCharacters(s):
    uniq = set()
    ans = []
    for ch in s:
        if ch not in uniq:
            ans.append(ch)
            uniq.add(ch)
    return ''.join(ans)

s = ['h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd']
ans = removeDuplicateCharacters(s)
print(ans)
