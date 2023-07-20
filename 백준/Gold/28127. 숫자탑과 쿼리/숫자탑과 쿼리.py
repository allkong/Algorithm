import sys
input = sys.stdin.readline

Q = int(input())
for _ in range(Q):
    a, d, x = map(int, input().split())
    i, total = 1, 1
    while True:
        tmp = a + (i - 1) * d
        if total + tmp > x:
            break
        total += tmp
        i += 1
    print(i, x - total + 1)