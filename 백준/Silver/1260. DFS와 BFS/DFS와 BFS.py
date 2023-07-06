from collections import deque
import sys
input = sys.stdin.readline

def dfs(graph, v, dfs_visited):
    dfs_visited[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not dfs_visited[i]:
            dfs(graph, i, dfs_visited)

def bfs(graph, start, bfs_visited):
    queue = deque([start])
    bfs_visited[start] = True
    while queue:
        v = queue.popleft()
        print(v, end=' ')
        for i in graph[v]:
            if not bfs_visited[i]:
                queue.append(i)
                bfs_visited[i] = True

n, m, v = map(int, input().split())

graph = [[] for i in range(n+1)]
dfs_visited = [False] * (n+1)
bfs_visited = [False] * (n+1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for g in graph:
    g.sort()

dfs(graph, v, dfs_visited)
print()
bfs(graph, v, bfs_visited)