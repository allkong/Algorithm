from collections import deque

n = int(input())
balloon = deque(enumerate(map(int, input().split())))

for i in range(n):
    idx, tmp = balloon.popleft()
    print(idx + 1, end=' ')
    if tmp > 0:
        balloon.rotate(-(tmp - 1))
    else:
        balloon.rotate(-tmp)