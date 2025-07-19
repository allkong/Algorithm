import sys
from collections import deque
input = sys.stdin.readline

num = input().rstrip()

n, i = 1, 0
while True:
    queue = deque(list(str(n)))

    while queue and i < len(num):
        x = queue.popleft()

        if num[i] == x:
            i += 1
    
    if i == len(num):
        break

    n += 1

print(n)