import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
calendar = defaultdict(int)

for _ in range(N):
    S, E = map(int, input().split())

    for i in range(S, E + 1):
        calendar[i] += 1

w, h, area = 0, 0, 0
start = min(calendar.keys())
end = max(calendar.keys())

for day in range(start, end + 1):
    if calendar[day] != 0:
        w += 1
        h = max(h, calendar[day])

    if calendar[day] == 0 or (day == end and calendar != 0):
        area += w * h
        w, h = 0, 0

print(area)