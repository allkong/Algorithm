from collections import deque 
import sys
input = sys.stdin.readline

m, n, h = map(int, input().split())

box = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

queue = deque()
for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 1:
                queue.append((i, j, k))

def bfs():
    dz = [0, 0, 0, 0, -1, 1]
    dx = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]

    while queue:
        z, x, y = queue.popleft()

        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]

            if nz < 0 or nz >= h or nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if box[nz][nx][ny] == 0:
                box[nz][nx][ny] = box[z][x][y] + 1
                queue.append((nz, nx, ny))

bfs()

ans = 0
for tomatoes in box:
    for tomato in tomatoes:
        if 0 in tomato:
            print(-1)
            exit(0)
        ans = max(ans, max(tomato))

print(ans - 1)