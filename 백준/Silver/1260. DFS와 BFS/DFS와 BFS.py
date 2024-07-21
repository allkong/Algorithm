from collections import deque
import sys
input = sys.stdin.readline

def dfs(graph, vertex, dfs_visited):
    # 현재 노드를 방문 처리
    dfs_visited[vertex] = True
    print(vertex, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for idx in graph[vertex]:
        if not dfs_visited[idx]:
            dfs(graph, idx, dfs_visited)

def bfs(graph, start, bfs_visited):
    queue = deque([start])
    # 현재 노드를 방문 처리
    bfs_visited[start] = True
    while queue:
        # 큐에서 방문할 원소 꺼내기
        vertex = queue.popleft()
        print(vertex, end=' ')
        # 아직 방문하지 않은 인접한 원소들을 큐에 삽입
        for idx in graph[vertex]:
            if not bfs_visited[idx]:
                queue.append(idx)
                bfs_visited[idx] = True

nodeCount, edgeCount, vertex = map(int, input().split())
graph = [[] for _ in range(nodeCount + 1)]
dfs_visited = [False] * (nodeCount + 1)
bfs_visited = [False] * (nodeCount + 1)

for _ in range(edgeCount):
    one, other = map(int, input().split())
    graph[one].append(other)
    graph[other].append(one)

for g in graph:
    g.sort()

dfs(graph, vertex, dfs_visited)
print()
bfs(graph, vertex, bfs_visited)