import sys
input = sys.stdin.readline

A, B = map(int, input().split())
M = (B - A) / 400
ans = 1 / (1 + 10 ** M)
print(ans)