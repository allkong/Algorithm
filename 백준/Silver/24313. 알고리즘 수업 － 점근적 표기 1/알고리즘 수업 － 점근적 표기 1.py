import sys
input = sys.stdin.readline

MAX_NUMBER = 100
a1, a0 = map(int, input().split())
c = int(input())
n = int(input()) # g(n)

# 모든 n >= n0에 대하여 f(n) <= c * g(n)인 양의 상수 c와 n0가 존재하면 참
for i in range(n, MAX_NUMBER + 1):
    # f(n) = a1 * n + a0
    f = a1 * i + a0

    if not (f <= c * i):
        print(0)
        exit(0)
print(1)