import sys
from collections import deque

n = int(input())
deq = deque()

for _ in range(n):
    com = sys.stdin.readline().split()

    if com[0] == 'push_front':
        deq.appendleft(com[1])

    elif com[0] == 'push_back':
        deq.append(com[1])

    elif com[0] == 'pop_front':
        if deq:
            print(deq.popleft())
        else:
            print(-1)

    elif com[0] == 'pop_back':
        if deq:
            print(deq.pop())
        else:
            print(-1)

    elif com[0] == 'size':
        print(len(deq))

    elif com[0] == 'empty':
        if deq:
            print(0)
        else:
            print(1)
    
    elif com[0] == 'front':
        if deq:
            print(deq[0])
        else:
            print(-1)

    elif com[0] == 'back':
        if deq:
            print(deq[-1])
        else:
            print(-1)
