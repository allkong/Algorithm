import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 4)

def find_room(cur, dst):
    global ans
    # 현재 위치한 방 방문 처리
    visited[cur] = True
    # 현재 위치한 방이 시작점에서 더 먼 방이면 거리 갱신
    ans = max(ans, dst)

    # 현재 위치한 방과 연결된 방들 탐색
    for node, cost in graph[cur]:
        # 아직 방문하지 않은 방이면 여태까지 이동한 거리에 다음 방으로의 이동 거리를 더해 다음 방으로 이동
        if not visited[node]:
            find_room(node, dst + cost)

n = int(input()) # 방 개수
graph = [[] for _ in range(n + 1)] # 방 사이의 길 정보
visited = [False] * (n + 1)
ans = 0 # 가장 먼 방까지의 이동 거리

for _ in range(n - 1):
    v1, v2, cost = map(int, input().split())
    # v1 <-> v2 양방향 길
    graph[v1].append((v2, cost))
    graph[v2].append([v1, cost])

# 가장 먼 방 찾기기
find_room(1, 0)
print(ans)