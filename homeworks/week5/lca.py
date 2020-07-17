#Time Complexity: O(h) where h is height of the induced tree
#Space: O(1)
def find_lca(parent, u, v):
    #No extra storage
    #First, count how many steps u and v need to reach the root
    N = len(parent)
    stepu, pu, stepv, pv = 0, u, 0, v
    while pu != -1:
        pu = parent[pu]
        stepu += 1
    while pv != -1:
        pv = parent[pv]
        stepv += 1
    #If one of the two nodes is on lower level than the other, take it up
    while stepu < stepv:
        v = parent[v]
        stepv -= 1
    while stepv < stepu:
        u = parent[u]
        stepu -= 1
    #Now u, v are on same level. they will go up together until parents are the same
    while v != u:
        u = parent[u]
        v = parent[v]
    print(v)
    return v
def main():
    boss = [1, 3, 3, -1, -1, 4, 2, 8, 3]
    #Naive method: O(N) for each query
    #Better method: Binary Lifting, O(logN) for each query, O(NlogN) precomputation
    find_lca(boss, 1, 1)
    find_lca(boss, 2, 0)
    find_lca(boss, 6, 0)
    find_lca(boss, 7, 1)
    find_lca(boss, 4, 5)
    find_lca(boss, 6, 5)
    find_lca(boss, 4, 2)
    find_lca(boss, 4, 3)
    find_lca(boss, 4, -1)
    pass
main()