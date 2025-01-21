import sys
input = sys.stdin.readline

def dfs(v):
    # 현재 노드를 방문 처리
    visited[v] = True

    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
count = 0

# 연결 정보로 그래프 만들기
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 방문하지 않은 노드면 탐색 시작
for i in range(1, n + 1):
    if not visited[i]:
        dfs(i)
        count += 1

print(count)