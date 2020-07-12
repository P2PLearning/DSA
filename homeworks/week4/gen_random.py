import random
class Segment:
    def __init__(self, a, b):
        self.start = a
        self.end = b
    def length(self):
        return self.end - self.start
    def __str__(self):
        return "[" + str(self.start) + ", " + str(self.end) + "]"

#Two-step randomizing: 1) Choose interval, based on its length. 2) Uniformly random a point on chosen interval
#Time Complexity: O(logN) since random.choice use binary search on cumulative weights for searching the index
#Auxiliary space: O(N) 
def generateRandomValue(intervals, weights):
    chosen = random.choices(intervals, cum_weights = weights, k = 1)[0]
    return random.uniform(chosen.start, chosen.end)
def main():
    NSAMPLE = 10**6
    intervals = []
    intervals.append(Segment(1, 3))
    intervals.append(Segment(2, 5))
    intervals.append(Segment(1, 4))
    intervals.append(Segment(0, 2))
    count = {}
    lengths = [x.length() for x in intervals]
    weights = [lengths[0]]
    for i in range(1, len(lengths)):
        weights.append(weights[-1] + lengths[i])
    for _ in range(1, NSAMPLE):
        k = int(generateRandomValue(intervals, weights))
        count[k] = count.get(k, 0) + 1
    count = {idx: count[idx]/NSAMPLE * 100 for idx in count}
    print(count) #{0: 10, 1: 30, 2: 30, 3: 20, 4: 10}

    # count = {}
    # intervals.append(Segment(-100, -90))
    # lengths = [x.length() for x in intervals]
    # for _ in range(1, NSAMPLE):
    #     k = int(generateRandomValue(intervals, lengths))
    #     count[k] = count.get(k, 0) + 1
    # count = {idx: count[idx]/NSAMPLE * 100 for idx in count}
    # print(count) #{0: 5, 1: 15, 2: 15, 3: 10, 4: 5, from -99 to -90: 5 each}

    # count = {}
    # intervals = [Segment(1, 3)]
    # lengths = [x.length() for x in intervals]
    # for _ in range(1, NSAMPLE):
    #     k = int(generateRandomValue(intervals, lengths))
    #     count[k] = count.get(k, 0) + 1
    # count = {idx: count[idx]/NSAMPLE * 100 for idx in count}
    # print(count) #{1: 50, 2: 50}

main()