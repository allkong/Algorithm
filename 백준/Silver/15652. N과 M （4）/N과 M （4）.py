import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline

N, M = map(int, input().split())
print('\n'.join(' '.join(map(str, p)) for p in combinations_with_replacement(range(1, N + 1), M)))