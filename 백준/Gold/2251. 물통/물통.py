from collections import deque
import sys
input = sys.stdin.readline

def pour(x, y):
    if not visited[x][y]:
        visited[x][y] = 1
        queue.append((x, y))

def bfs():
    while queue:
        x, y = queue.popleft()
        z = c - x - y

        if x == 0:
            ans.append(z)
        
        w = min(x, b - y)
        pour(x - w, y + w)

        w = min(x, c - z)
        pour(x - w, y)

        w = min(y, a - x)
        pour(x + w, y - w)

        w = min(y, c - z)
        pour(x, y - w)

        w = min(z, a - x)
        pour(x + w, y)

        w = min(z, b - y)
        pour(x, y + w)

a, b, c = map(int, input().split())
ans = []
queue = deque([(0, 0)])
visited = [[0] * (b + 1) for _ in range(a + 1)]
visited[0][0] = 1
bfs()
ans.sort()
print(*ans)