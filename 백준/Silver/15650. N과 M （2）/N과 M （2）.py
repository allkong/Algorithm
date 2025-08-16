import sys
from itertools import combinations
input = sys.stdin.readline

N, M = map(int, input().split())
print('\n'.join(' '.join(map(str, p)) for p in combinations(range(1, N + 1), M)))