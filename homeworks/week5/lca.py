
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
#Binary Lifting. This will allow us to find lca in O(logH) for each query. This is better in case the number of query is large, for example nquery = O(N). 
#Time Complexity: Nlog(H). Here instead of logH I use step = const = 10, so TC = O(N)
#Space: O(NlogH), in below implemenation: O(N)
#Details: https://cp-algorithms.com/graph/lca_binary_lifting.html
def binary_lifting(parent):
    N = len(parent)
    ancestors = [{i: parent[i] for i in range(N)}]
    step = 10 #2**10 = 1024
    print(ancestors)
    for _ in range(step):
        B = {}
        for i in ancestors[-1]:
            if ancestors[-1][i] in ancestors[-1]:
                B[i] = ancestors[-1][ancestors[-1][i]]
        ancestors.append(B)
def find_lca_binarylift(parent, u, v):
    pass
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
    
    binary_lifting(boss)
main()