import sys
from collections import deque
input = sys.stdin.readline

def dfs(y, x, d):
    global case

    if (y, x) == (0, C - 1):
        if d == K:
            case += 1
        return
    
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]

        if (0 <= ny < R) and (0 <= nx < C) and not visited[ny][nx]:
            if board[ny][nx] == '.':
                visited[ny][nx] = True
                dfs(ny, nx, d + 1)
                visited[ny][nx] = False

R, C, K = map(int, input().split())
board = [list(input().rstrip()) for _ in range(R)]
visited = [[False] * C for _ in range(R)]
visited[R - 1][0] = True
case = 0

dy = [-1, 1, 0, 0] 
dx = [0, 0, -1, 1]

dfs(R - 1, 0, 1)
print(case)