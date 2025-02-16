import sys
input = sys.stdin.readline

n = int(input())

start, end = 0, n # (F, T]

while start + 1 < end:
    mid = (start + end) // 2

    if mid ** 2 < n:
        start = mid
    else:
        end = mid

print(end)