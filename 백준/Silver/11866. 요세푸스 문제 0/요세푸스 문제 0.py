from collections import deque

n, k = map(int, input().split())

q = deque(range(1, n + 1))

print('<', end='')
while q:
    for i in range(k - 1):
        q.append(q.popleft())
    print(q.popleft(), end='')
    if q:
        print(', ', end='')
print('>')