from collections import deque
import sys
input = sys.stdin.readline

def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque([(x, y)])
    cnt = 0

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                visited[nx][ny] = 1
                if board[nx][ny] == 0:
                    queue.append((nx, ny))
                else:
                    board[nx][ny] = 0
                    cnt += 1
    
    ans.append(cnt)
    return cnt

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
ans = []
hour = 0

while True:
    visited = [[0] * m for _ in range(n)]
    cnt = bfs(0, 0)
    if cnt == 0:
        print(hour, ans[-2], sep='\n')
        break
    hour += 1