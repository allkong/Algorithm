import sys
from collections import deque

input = sys.stdin.readline

def bfs(n):
    queue = deque([(n, "")])
    visited = [False] * 10000
    visited[n] = True

    while queue:
        cur, command = queue.popleft()

        if cur == B:
            print(command)
            return

        for c, after in (('D', (cur * 2) % 10000), 
                         ('S', (cur - 1) % 10000),
                         ('L', (cur % 1000) * 10 + cur // 1000),
                         ('R', (cur % 10) * 1000 + cur // 10)):
            
            if not visited[after]:
                visited[after] = True
                queue.append((after, command + c))

T = int(input())
for _ in range(T):
    A, B = map(int, input().split())
    bfs(A)