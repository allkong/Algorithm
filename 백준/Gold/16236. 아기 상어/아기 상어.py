from collections import deque
import sys
input = sys.stdin.readline

def bfs(x, y, size):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque([(x, y, 0)])
    candidate = []
    visited[x][y] = 1

    while queue:
        x, y, d = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if size >= board[nx][ny]:
                    visited[nx][ny] = 1
                    queue.append((nx, ny, d + 1))

                    if size > board[nx][ny] and board[nx][ny]:
                        candidate.append((nx, ny, d + 1))
    
    return sorted(candidate, key=lambda x: (x[2], x[0], x[1]))

n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
sec, cnt, size = 0, 0, 2
for i in range(n):
    for j in range(n):
        if board[i][j] == 9:
            x, y = i, j
            shark_x, shark_y = i, j
            break

while True:
    visited = [[0] * n for _ in range(n)]
    candidate = deque(bfs(x, y, size))

    if not candidate:
        print(sec)
        break
    
    nx, ny, d = candidate.popleft()
    sec += d
    board[x][y], board[nx][ny] = 0, 0
    x, y = nx, ny
    shark_x, shark_y = nx, ny
    cnt += 1

    if cnt == size:
        cnt = 0
        size += 1
