from collections import deque
import sys
input = sys.stdin.readline

def cleaning(x, y, d):
    global cnt
    if room[x][y] == 0:
        room[x][y] = 2
        cnt += 1

    for _ in range(4):
        d = (d + 3) % 4
        nx = x + dx[d]
        ny = y + dy[d]

        if room[nx][ny] == 0:
            cleaning(nx, ny, d)
            return

    nd = (d + 2) % 4
    nx = x + dx[nd]
    ny = y + dy[nd]

    if room[nx][ny] == 1:
        return
    
    cleaning(nx, ny, d)

n, m = map(int, input().split())
x, y, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
cnt = 0
cleaning(x, y, d)
print(cnt)