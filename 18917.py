import sys
m = int(input())
s = 0
x = 0
for i in range(m):
    q = list(map(int, sys.stdin.readline().split()))
    if q[0] == 1:
        s += q[1]
        x ^= q[1]
    elif q[0] == 2:
        s -= q[1]
        x ^= q[1]
    elif q[0] == 3:
        print(s)
    else:
        print(x)