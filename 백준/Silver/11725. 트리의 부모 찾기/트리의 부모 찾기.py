import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 5)

def dfs(parent):
    # 부모 노드와 연결된 자식 노드들을 탐색한다
    for child in graph[parent]:
        # 아직 방문하지 않은 노드면 방문한다다
        if not visited[child]:
            # 부모 노드와 연결된 자식 노드를 방문 처리한다
            # 방문 처리에는 T/F가 아닌 자신의 부모 노드 번호를 기록한다
            visited[child] = parent
            dfs(child)

n = int(input())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

# 간선 정보로 그래프 만들기
for _ in range(n - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(1)
print(*visited[2:], sep='\n')