import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        # 상하좌우를 탐색한다
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위를 벗어나면 탐색하지 않는다
            if nx < 0 or nx >= row_size or ny < 0 or ny >= col_size:
                continue

            # 안익은 토마토가 있는 칸이면 하루를 더해서 기록한다
            # 다음 토마토를 탐색한다
            if box[nx][ny] == 0:
                box[nx][ny] = box[x][y] + 1
                queue.append((nx, ny))

col_size, row_size = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(row_size)]
queue = deque()
days = 0 # 토마토가 모두 익을 때까지의 최소 날짜

# 익은 토마토가 있는 칸을 모두 찾아 위치를 저장한다
for i in range(row_size):
    for j in range(col_size):
        if box[i][j] == 1:
            queue.append((i, j))

bfs()

for row in box:
    # 토마토가 모두 익지는 못하는 상황이면 -1을 출력한다
    if 0 in row:
        print(-1)
        exit(0)
    days = max(days, max(row))

# 시작이 1이므로 하루는 제외한다
print(days - 1)