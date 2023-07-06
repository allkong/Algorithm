def dfs(graph, v, visited):
    visited[v] = 1
    for i in graph[v]:
        if visited[i] == 0:
            dfs(graph, i, visited)

computer = int(input())
network_com = int(input())

graph = [[] for i in range(computer+1)]
visited = [0] * (computer+1)

for i in range(network_com):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(graph, 1, visited)
print(sum(visited)-1)