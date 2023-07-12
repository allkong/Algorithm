from collections import deque
import sys
input = sys.stdin.readline

def bfs():
    queue = deque()
    queue.append((hx, hy))

    while queue:
        x, y = queue.popleft()
        
        if abs(fx - x) + abs(fy - y) <= 1000:
                return "happy"
            
        for i in range(n):
            if not visited[i]:
                nx, ny = coordinate[i]
                if abs(nx - x) + abs(ny - y) <= 1000:
                    visited[i] = True
                    queue.append((nx, ny))
        
    return "sad"

t = int(input())
for _ in range(t):
    n = int(input())
    coordinate = []
    visited = [False] * n

    hx, hy = map(int, input().split())
    for _ in range(n):
        coordinate.append(tuple(map(int, input().split())))
    fx, fy = map(int, input().split())

    print(bfs())