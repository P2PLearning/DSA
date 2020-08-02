#!/usr/bin/env python3

import random

class Interval:
    def __init__(self, low, high):
        self.low = low
        self.high = high

    def len(self):
        return self.high - self.low

# time complexity: O(n)
# space complexity: O(1)
def generate_random_value(intervals):
    total_weight = 0
    for interval in intervals:
        total_weight += interval.len()

    r = random.uniform(0, total_weight)
    for idx, interval in enumerate(intervals):
        if r < interval.len(): return interval.low + r
        r -= interval.len()

intervals = [
    Interval(1, 3),
    Interval(2, 5),
    Interval(1, 4),
    Interval(0, 2)
]

# lets generate some random numbers
count = 100000
result_slot = [0,0,0,0,0]
while count > 0:
    res = generate_random_value(intervals)
    result_slot[int(res)] += 1
    count -= 1

# print the result
test_result = [10, 30, 30, 20, 10]
i = 1
while i <= 5:
    probability = 100 * result_slot[i - 1] / 100000
    print ('Interval [{}, {}] with probability {}%'.format(
        i - 1,
        i,
        probability,
    ))
    assert(abs(test_result[i-1] - probability) < 1)
    i += 1

