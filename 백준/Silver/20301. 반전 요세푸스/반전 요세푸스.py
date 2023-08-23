from collections import deque
import sys
input = sys.stdin.readline

n, k, m = map(int, input().split())
queue = deque(range(1, n+1))

k = -k+1
cnt = 0

while queue:
    if cnt == m:
        k = -k+1
        cnt = 0
    
    queue.rotate(k)
    print(queue.popleft())
    cnt += 1