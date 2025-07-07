import sys
from collections import deque
input = sys.stdin.readline

def bfs(shark):
    visited = [[False] * M for _ in range(N)]
    queue = deque([shark + (1,)])

    while queue:
        y, x, d = queue.popleft()
        
        for i in range(8):
            ny = y + dy[i]
            nx = x + dx[i]
            
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
                board[ny][nx] = min(board[ny][nx], d)
                queue.append((ny, nx, d + 1))
                visited[ny][nx] = True            

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
sharks = []
ans = 0

dy = [-1, 1, 0, 0, -1, -1, 1, 1]
dx = [0, 0, -1, 1, -1, 1, -1, 1]

# 상어의 위치 찾기
for i in range(N):
    for j in range(M):
        if board[i][j] == 1:
            sharks.append((i, j))
            board[i][j] = -1
        else:
            board[i][j] = sys.maxsize

# 상어에서 다른 칸까지의 거리 구하기
for shark in sharks:
    bfs(shark)

# 안전 거리 최댓값 구하기
for i in range(N):
    ans = max(ans, max(board[i]))
print(ans)