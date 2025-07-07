import sys
from collections import deque
input = sys.stdin.readline
INF = sys.maxsize

def bfs(sharks):
    queue = deque(sharks)
    max_dis = 0 # 안전 거리의 최댓값

    while queue:
        y, x = queue.popleft()
        
        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < N and 0 <= nx < M:
                # 이전에 구한 안전 거리보다 새로 구한 안전 거리가 더 짧다면 갱신하기
                if visited[y][x] + 1 < visited[ny][nx]:
                    visited[ny][nx] = visited[y][x] + 1
                    max_dis = max(max_dis, visited[ny][nx])
                    queue.append((ny, nx))
    
    return max_dis

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[INF] * M for _ in range(N)]
sharks = []
ans = 0

dy = [-1, 1, 0, 0, -1, -1, 1, 1]
dx = [0, 0, -1, 1, -1, 1, -1, 1]

# 상어의 위치 찾기
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            sharks.append((i, j))
            visited[i][j] = 0

# 안전 거리 구하기
print(bfs(sharks))