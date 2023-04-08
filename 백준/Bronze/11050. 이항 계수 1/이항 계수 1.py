from itertools import combinations

n, k = map(int, input().split())
arr = [0] * n
c = list(combinations(arr, k))
print(len(c))