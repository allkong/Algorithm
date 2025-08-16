import sys
from itertools import product
input = sys.stdin.readline

N, M = map(int, input().split())
print('\n'.join(' '.join(map(str, p)) for p in product(range(1, N + 1), repeat=M)))