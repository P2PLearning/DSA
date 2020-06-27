# Overall comments: If this is an answer during a coding interview; then No Hire (or may be borderline depending the position).
# Details comments:
# 1. Please provide space and time complexity.
# 2. Please add more tests
# 3. Please use more readable variables (uniq, ans). Acronym is usually not recommended in code.
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
