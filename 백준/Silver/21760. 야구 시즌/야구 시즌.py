import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N, M, k, D = map(int, input().split())

    same = N * (M * (M - 1) // 2)
    other = (N * (N - 1) // 2) * M * M
    C = same * k + other
    B = D // C

    print(-1 if B < 1 else B * C)