import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

cnt = N
s = 1
for i in range(1, N):
    if A[i - 1] < A[i]:
        s += 1
    else:
        if s > 1:
            cnt += s * (s - 1) // 2
            s = 1

if s > 1:
    cnt += s * (s - 1) // 2

print(cnt)