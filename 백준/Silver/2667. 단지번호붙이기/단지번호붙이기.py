import sys
from collections import deque
input = sys.stdin.readline

dx = (-1, 1, 0, 0)
dy = (0, 0, -1, 1)

def bfs(x, y):
    queue = deque([(x, y)])
    house[x][y] = 2
    cnt = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if (0 <= nx < n) and (0 <= ny < n):
                if house[nx][ny] == 1:
                    house[nx][ny] = 2
                    cnt += 1
                    queue.append((nx, ny))

    res.append(cnt)

n = int(input())
house = [list(map(int, input().rstrip())) for _ in range(n)]
res = []

for i in range(n):
    for j in range(n):
        if house[i][j] == 1:
            bfs(i, j)

print(len(res))
print(*sorted(res), sep='\n')