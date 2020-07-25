#!/usr/bin/env python3

"""
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T
// Input: S = "xyyzyzyx" T = "xyz”		Output: "zyx"
"""

from collections import Counter

def check_window_valid(current_count, expected_count):
    for i in expected_count:
        if i not in current_count:
            return False
    return True
    
# time complexity == 2 time loop through an array (2 pointer) == O(n)
# space complexity O(n): cause we maintain 2 hash:
# - expected_chars: contains hash represent of input_t
# - windows_counts: represent characters in sliding window
def find_min_windows_substring(input_s, input_t):
    if (input_s is None) or (input_t is None):
        return ""

    # use two pointer to form a sliding window
    left_ptr = 0
    right_ptr = 0
    formed = 0

    expected_chars = Counter(input_t)
    windows_counts = Counter()
    answer = input_s

    while right_ptr < len(input_s):
        char = input_s[right_ptr]
        windows_counts[char] += 1

        if check_window_valid(windows_counts, expected_chars):
            # shrink left pointer to find min window
            while (left_ptr < right_ptr) and check_window_valid(windows_counts, expected_chars):
                # save the answers
                temp_answers = input_s[left_ptr:right_ptr + 1]
                if len(answer) > len(temp_answers):
                    answer = temp_answers
                char = input_s[left_ptr]
                windows_counts[char] -= 1
                # remove zero counts from this counter
                windows_counts += Counter()
                left_ptr += 1

        # expand right pointer to have a bigger window
        right_ptr += 1
    return answer


assert (find_min_windows_substring("xyyzyzyx", "xyz") == "zyx")
assert (find_min_windows_substring("abcdeaaabfbcc", "def") == "deaaabf")

