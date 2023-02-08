import sys
from collections import deque

n = int(input())
q = deque()

for _ in range(n):
    com = sys.stdin.readline().split()

    if com[0] == 'push':
        q.append(com[1])
  
    elif com[0] == 'pop':
        if q:
            print(q.popleft())
        else:
            print(-1)
  
    elif com[0] == 'size':
        print(len(q))
  
    elif com[0] == 'empty':
        if q:
            print(0)
        else:
            print(1)
  
    elif com[0] == 'front':
        if q:
            print(q[0])
        else:
            print(-1)
  
    elif com[0] == 'back':
        if q:
            print(q[-1])
        else:
            print(-1)