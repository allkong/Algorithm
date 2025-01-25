import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
queue = deque(list(input().split()) for _ in range(n))

while len(queue) > 1:
    front = queue.popleft()
    queue.rotate(1 - int(front[1]))
    queue.popleft()

print(queue[0][0])