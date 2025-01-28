import sys
input = sys.stdin.readline

find = input().rstrip()
n = int(input())
length = len(find)
cnt = 0

for _ in range(n):
    ring = input().rstrip()

    for i in range(len(ring)):
        target = ''

        if i > len(ring) - length:
            target = ring[i:] + ring[:(i + length) % len(ring)]
        else:
            target = ring[i:i + length]

        if find == target:
            cnt += 1
            break

print(cnt)