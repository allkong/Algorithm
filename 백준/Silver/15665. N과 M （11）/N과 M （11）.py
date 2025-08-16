import sys
input = sys.stdin.readline

def permutation(depth):
    if depth == M:
        print(*path)
        return

    prev = None
    for i in range(N):
        if num[i] != prev:
            prev = num[i]
            path[depth] = num[i]
            permutation(depth + 1)

N, M = map(int, input().split())
num = sorted(map(int, input().split()))
path = [0] * M

permutation(0)