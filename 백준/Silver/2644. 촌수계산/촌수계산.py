import sys
input = sys.stdin.readline

def dfs(graph, v, visited):
    visited[v] = True
    for i in graph[v]:
        if not visited[i]:
            res[i] = res[v] + 1
            dfs(graph, i, visited)


n = int(input())
me, other = map(int, input().split())
m = int(input())

graph = [[] for i in range(n+1)]
visited = [False] * (n+1)
res = [0] * (n+1)

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

dfs(graph, me, visited)

if res[other] > 0:
    print(res[other])
else:
    print(-1)
