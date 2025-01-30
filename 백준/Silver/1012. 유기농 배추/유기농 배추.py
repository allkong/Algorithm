import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    dx = [-1, 1, 0, 0] # 상하좌우
    dy = [0, 0, -1, 1]

    queue = deque([(x, y)])
    farm[x][y] = 2

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위를 벗어나면 탐색하지 않는다
            if nx < 0 or nx >= row_size or ny < 0 or ny >= col_size:
                continue

            # 배추가 심어져 있는 땅이면 방문 처리(2)하고 이어서 탐색한다다
            elif farm[nx][ny] == 1:
                farm[nx][ny] = 2
                queue.append((nx, ny))

t = int(input())
for _ in range(t):
    col_size, row_size, k = map(int, input().split()) # 가로 길이, 세로 길이, 배추가 심어져 있는 위치의 개수
    farm = [[0 for _ in range(col_size)] for _ in range(row_size)]
    cnt = 0 # 필요한 최소의 배추흰지렁이 마리 수

    # 배추의 위치 기록록
    for _ in range(k):
        col, row = map(int, input().split())
        farm[row][col] = 1

    # 방문하지 않은 배추가 심어져 있는 땅이면 탐색한다
    for row in range(row_size):
        for col in range(col_size):
            if farm[row][col] == 1:
                bfs(row, col)
                cnt += 1

    print(cnt)