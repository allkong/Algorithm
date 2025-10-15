import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
queue = deque([])

for _ in range(n):
    c = list(input().split())
    if c[0] in ['1','2']:
        queue.append(c)
    else:
        if queue:
            queue.pop()

res = deque([])
while queue:
    cmd,s = queue.popleft()
    
    if cmd == '1':
        res.append(s)
    else:
        res.appendleft(s)

if not res:
    print(0)
else:
    print(''.join(list(res)))