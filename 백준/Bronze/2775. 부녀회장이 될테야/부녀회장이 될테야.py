import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    k = int(input())
    n = int(input())
    floor = [i for i in range(1, n+1)]
    for f in range(k):
        for i in range(1, n):
            floor[i] += floor[i-1]
    print(floor[-1])