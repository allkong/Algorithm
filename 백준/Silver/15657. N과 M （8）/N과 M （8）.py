import sys
from itertools import combinations_with_replacement
input = sys.stdin.readline

N, M = map(int, input().split())
num = sorted(map(int, input().split()))
print('\n'.join(' '.join(map(str, p)) for p in combinations_with_replacement(num, M)))