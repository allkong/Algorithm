import sys
input = sys.stdin.readline

N = int(input())
A = list(map(lambda x: int(x) - 1, input().split()))
res = [-1] * N

l, r = 0, 1
while r != N:
    if A[l] == A[r]:
        r += 1
    else:
        res[l:r] = [r + 1] * (r - l)
        l = r
        r = l + 1

print(*res)