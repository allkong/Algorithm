import sys
input = sys.stdin.readline

n = int(input())
adj = [list(map(int, input().split())) for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            if adj[i][k] and adj[k][j]:
                adj[i][j] = 1

for row in adj:
    print(*row)