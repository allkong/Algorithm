import sys
input = sys.stdin.readline

length = int(input())
dot = [sorted(map(int, input().split())) for _ in range(3)]
mid = 0

for i in range(3):
    l, r = dot[i]

    if l == r:
        continue

    mid = (l + r) / 2

    for j in range(i + 1, 3):
        dot[j][0] = abs(mid - dot[j][0])
        dot[j][1] = abs(mid - dot[j][1])
    
    length = max(mid, length - mid)

print(length)