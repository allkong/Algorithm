import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def find_room(v, dst):
    visited[v] = True

    for node in graph[v]:
        if not visited[node[0]]:
            node[1] += dst
            find_room(node[0], node[1])

n = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
ans = 0

for _ in range(n - 1):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

find_room(1, 0)

for row in graph:
    for col in row:
        ans = max(ans, max(col))

print(ans)