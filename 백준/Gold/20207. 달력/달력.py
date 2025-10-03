import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
calendar = defaultdict(int)

for _ in range(N):
    S, E = map(int, input().split())

    for i in range(S, E + 1):
        calendar[i] += 1

w, h = 0, 1
area = 0 # 코딩지 면적
day = min(calendar.keys())
last = max(calendar.keys())

while day <= last:
    if calendar[day] != 0:
        w += 1
        h = max(h, calendar[day])

    if calendar[day] == 0 or (day == last and calendar != 0):
        area += w * h
        w, h = 0, 1
    
    day += 1

print(area)