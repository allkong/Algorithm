import sys
from collections import deque
input = sys.stdin.readline

dz = (0, 0, 0, 0, -1, 1)
dy = (-1, 1, 0, 0, 0, 0)
dx = (0, 0, -1, 1, 0, 0)

def bfs():
    while queue:
        z, y, x, m = queue.popleft()

        # 6방향(북남서동상하)을 탐색한다
        for i in range(6):
            nz = z + dz[i]
            ny = y + dy[i]
            nx = x + dx[i]

            # 다음 위치가 범위를 벗어나면 탐색하지 않는다
            if nz < 0 or nz >= l or ny < 0 or ny >= r or nx < 0 or nx >= c:
                continue

            # 이미 방문한 칸이면 탐색하지 않는다
            if visited[nz][ny][nx]:
                continue

            # 다음 칸이 출구면 탈출한다
            if building[nz][ny][nx] == 'E':
                print(f'Escaped in {m + 1} minute(s).')
                return

            # 다음 칸이 비어있는 칸이거나 출구면 이동한다
            if building[nz][ny][nx] == '.':
                visited[nz][ny][nx] = True
                queue.append((nz, ny, nx, m + 1))
    
    print('Trapped!')
    return

while True:
    l, r, c = map(int, input().split()) # 층 수, 행 개수, 열 개수
    
    if l == r == c == 0:
        break

    building = []
    visited = [[[False] * c for _ in range(r)] for _ in range(l)]

    # 빌딩의 칸 정보를 입력받는다
    for _ in range(l):
        building.append([list(input().rstrip()) for _ in range(r)])
        input()

    # 시작 지점 위치를 찾아서 저장한다
    for z in range(l):
        for y in range(r):
            for x in range(c):
                if building[z][y][x] == 'S':
                    visited[z][y][x] = True
                    queue = deque([(z, y, x, 0)])
    
    bfs()