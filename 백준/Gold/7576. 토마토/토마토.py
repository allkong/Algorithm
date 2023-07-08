from collections import deque 
import sys
input = sys.stdin.readline

m, n = map(int, input().split())

box = []
for _ in range(n):
    box.append(list(map(int, input().split())))

queue = deque()
for i in range(n):
    for j in range(m):
        if box[i][j] == 1:
            queue.append((i, j))

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append((nx, ny))

bfs()

ans = 0
for tomatoes in box:
    if 0 in tomatoes:
        print(-1)
        exit(0)
    ans = max(ans, max(tomatoes))

print(ans-1)