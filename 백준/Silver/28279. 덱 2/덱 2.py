from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
dq = deque()
for _ in range(n):
    c = input().split()
    if c[0] == '1':
        dq.appendleft(int(c[1]))
    elif c[0] == '2':
        dq.append(int(c[1]))
    elif c[0] == '3':
        print(dq.popleft() if dq else -1)
    elif c[0] == '4':
        print(dq.pop() if dq else -1)
    elif c[0] == '5':
        print(len(dq))
    elif c[0] == '6':
        print(1 if not dq else 0)
    elif c[0] == '7':
        print(dq[0] if dq else -1)
    else:
        print(dq[-1] if dq else -1)