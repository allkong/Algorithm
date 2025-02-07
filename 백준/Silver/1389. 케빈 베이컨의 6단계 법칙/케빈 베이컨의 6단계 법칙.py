import sys
input = sys.stdin.readline

n, m = map(int, input().split())
adj = [[n for _ in range(n)] for _ in range(n)]

for _ in range(m):
    i, j = map(int, input().split())
    adj[i - 1][j - 1] = 1
    adj[j - 1][i - 1] = 1

for k in range(n):
    for i in range(n):
        for j in range(n):
            if i == j:
                adj[i][j] = 0
            else:
                adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j])

num = []
for row in adj:
    num.append(sum(row))
print(num.index(min(num)) + 1)