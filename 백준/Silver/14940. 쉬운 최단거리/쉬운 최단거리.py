from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [(list(map(int, input().split()))) for _ in range(n)]
visited = [[-1] * m for _ in range(n)]

def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((x, y))

    visited[x][y] = 0

    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i] 
        
            if nx < 0 or nx >= n or ny < 0 or ny >= m or visited[nx][ny] != -1:
                continue

            elif board[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))

for i in range(n):
    for j in range(m):
        if board[i][j] == 2:
            bfs(i, j)
        elif board[i][j] == 0:
            visited[i][j] = 0
            

for v in visited:
    print(*v, sep=' ')