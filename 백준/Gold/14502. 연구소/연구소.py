from collections import deque
import copy
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
ori_lab = [list(map(int, input().split())) for _ in range(n)]
    
def bfs():
    lab = copy.deepcopy(ori_lab)
    queue = deque()
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 2:
                queue.append((i, j))

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            if lab[nx][ny] == 0:
                lab[nx][ny] = 2
                queue.append((nx, ny))

    global ans
    cnt = 0
    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                cnt += 1
    ans = max(ans, cnt)

def make_wall(wall):
    if wall == 3:
        bfs()
        return
    
    for i in range(n):
        for j in range(m):
            if ori_lab[i][j] == 0:
                ori_lab[i][j] = 1
                make_wall(wall+1)
                ori_lab[i][j] = 0

ans = 0
make_wall(0)
print(ans)