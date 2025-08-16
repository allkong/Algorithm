import sys
from itertools import permutations
input = sys.stdin.readline

N, M = map(int, input().split())
num = sorted(list(map(int, input().split())))

for i in permutations(num, M):
    print(*i)