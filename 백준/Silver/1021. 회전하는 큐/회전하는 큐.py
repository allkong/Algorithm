from collections import deque

n, m = map(int, input().split())
idx = list(map(int, input().split()))
dq = deque(range(1, n + 1))
cnt = 0

for i in idx:
    while True:
        if i == dq[0]:
            dq.popleft()
            break
        
        else:
            if dq.index(i) <= len(dq)//2:
                dq.rotate(-1)
                cnt += 1
        
            else:
                dq.rotate(1)
                cnt += 1

print(cnt)