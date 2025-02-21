import sys
from collections import deque
input = sys.stdin.readline

def bfs(n):
    queue = deque([(n, ())])
    visited = set()
    visited.add(n)

    while queue:
        cur, command = queue.popleft()

        if cur == B:
            print(''.join(command))
            return

        for c in ('D', 'S', 'L', 'R'):
            if c == 'D':
                after = (cur * 2) % 10000
            elif c == 'S':
                after = cur - 1 if cur != 0 else 9999
            elif c == 'L':
                after = (cur % 1000) * 10 + cur // 1000
            elif c == 'R':
                after = (cur % 10) * 1000 + cur // 10
            
            if after not in visited:
                queue.append((after, command + (c,)))
                visited.add(after)

T = int(input())
for _ in range(T):
    A, B = map(int, input().split()) # 초기 값, 최종 값
    bfs(A)