import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
calendar = [0] * 367

for _ in range(N):
    S, E = map(int, input().split())

    for i in range(S, E + 1):
        calendar[i] += 1

w, h, area = 0, 0, 0

for day in range(1, len(calendar)):
    if calendar[day] != 0:
        w += 1
        h = max(h, calendar[day])

    else:
        area += w * h
        w, h = 0, 0

print(area)