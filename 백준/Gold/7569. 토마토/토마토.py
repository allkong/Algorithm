import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    dz = [0, 0, 0, 0, -1, 1]
    dx = [-1, 1, 0, 0, 0, 0]
    dy = [0, 0, -1, 1, 0, 0]

    while queue:
        z, x, y = queue.popleft()

        # 같은 높이의 상하좌우와 위, 아래를 탐색한다
        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위를 벗어나면 탐색하지 않는다
            if nz < 0 or nz >= height or nx < 0 or nx >= row_size or ny < 0 or ny >= col_size:
                continue

            # 안익은 토마토가 있는 칸이면 하루를 더해서 기록한다
            # 다음 토마토를 탐색한다
            if boxes[nz][nx][ny] == 0:
                boxes[nz][nx][ny] = boxes[z][x][y] + 1
                queue.append((nz, nx, ny))

col_size, row_size, height = map(int, input().split())
boxes = [[list(map(int, input().split())) for _ in range(row_size)] for _ in range(height)]
queue = deque()
days = 0 # 토마토가 모두 익을 때까지의 최소 날짜

# 익은 토마토가 있는 칸을 모두 찾아 위치를 저장한다
for i in range(height):
    for j in range(row_size):
        for k in range(col_size):
            if boxes[i][j][k] == 1:
                queue.append((i, j, k))

bfs()

for box in boxes:
    for row in box:
        # 토마토가 모두 익지는 못하는 상황이면 -1을 출력한다
        if 0 in row:
            print(-1)
            exit(0)
        days = max(days, max(row))

# 시작이 1이므로 하루는 제외한다
print(days - 1)