import sys
from collections import deque
input = sys.stdin.readline

def bfs(x, y):
    dx = (-1, 1, 0, 0)
    dy = (0, 0, -1, 1)
    
    queue = deque([(x, y)])
    visited[x][y] = True
    cnt = 0 # 만난 사람 수

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            # 다음 칸이 이동 가능한 칸이면 이동한다
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and campus[nx][ny] != 'X':
                # 만약 다음 칸이 사람이면 만난 사람 수가 증가한다   
                if campus[nx][ny] == 'P':
                    cnt += 1
                # 이어서 탐색한다
                visited[nx][ny] = True
                queue.append((nx, ny))
    
    print(cnt or 'TT')

n, m = map(int, input().split())
campus = [input() for _ in range(n)]
visited = [[False] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if campus[i][j]  == 'I':
            bfs(i, j)
            exit(0)