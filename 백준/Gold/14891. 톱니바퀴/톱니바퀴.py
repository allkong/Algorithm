from collections import deque
import sys
input = sys.stdin.readline

def left_gear(n, d):
    if n > -1 and gears[n][2] != gears[n+1][6]:
        left_gear(n-1, -d)
        gears[n].rotate(d)

def right_gear(n, d):
    if n < 4 and gears[n][6] != gears[n-1][2]:
        right_gear(n+1, -d)
        gears[n].rotate(d)

gears = [deque(map(int, input().rstrip())) for _ in range(4)]
k = int(input())

for _ in range(k):
    n, d = map(int, input().split())
    left_gear(n-2, -d)
    right_gear(n, -d)
    gears[n-1].rotate(d)

score = 0
for i in range(4):
    score += gears[i][0] * (2 ** i)
print(score)