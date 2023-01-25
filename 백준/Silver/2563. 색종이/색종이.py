import sys

t = int(input())
space = [[0] * 100 for _ in range(100)]

for _ in range(t):
    x, y = map(int, sys.stdin.readline().split())

    for i in range(x, x + 10):
        for j in range(y, y + 10):
            space[i][j] = 1

area = 0
for k in range(100):
    area += space[k].count(1)

print(area)