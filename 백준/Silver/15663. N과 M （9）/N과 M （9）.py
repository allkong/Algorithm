import sys
input = sys.stdin.readline

def permutation(depth):
    if depth == M:
        print(*path)
        return

    prev = None
    for i in range(N):
        if num[i] != prev and not selected[i]:
            prev = num[i]

            selected[i] = True
            path[depth] = num[i]

            permutation(depth + 1)
            selected[i] = False

N, M = map(int, input().split())
num = sorted(map(int, input().split()))
selected = [False] * N
path = [0] * M

permutation(0)