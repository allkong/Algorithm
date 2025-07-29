import sys
from itertools import permutations
input = sys.stdin.readline

voca = [input().rstrip() for _ in range(6)]

for p in permutations(voca):
    horizontal = p[:3]
    vertical = p[3:]

    if all(horizontal[j][i] == vertical[i][j] for i in range(3) for j in range(3)):
        print(*p[:3], sep='\n')
        exit()

print(0)