from collections import deque
import sys
input = sys.stdin.readline

N, L, R = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

def bfs(x, y):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((x, y))
    check = []
    check.append((x, y))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < N and visited[nx][ny] == 0:
                if L <= abs(A[x][y] - A[nx][ny]) <= R:
                    visited[nx][ny] = 1
                    queue.append((nx, ny))
                    check.append((nx, ny))
        
    return check

cnt = 0
while True:
    visited = [[0] * N for _ in range(N)]
    flag = 0
    for r in range(N):
        for c in range(N):
            if visited[r][c] == 0:
                visited[r][c] = 1
                check = bfs(r, c)

                if len(check) > 1:
                    flag = 1
                    res = sum(A[x][y] for x, y in check) // len(check)

                    for x, y in check:
                        A[x][y] = res
                
    if not flag:
        print(cnt)
        break

    cnt += 1