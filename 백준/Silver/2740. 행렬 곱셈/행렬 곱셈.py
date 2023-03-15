import sys
input = sys.stdin.readline

N, M = map(int, input().split())
a = []
for _ in range(N):
    a.append(list(map(int, input().split())))

M, K = map(int, input().split())
b = []
for _ in range(M):
    b.append(list(map(int, input().split())))

for n in range(N):
    for k in range(K):
        c = 0
        for m in range(M):
            c += a[n][m] * b[m][k]
        print(c, end=' ')
    print()