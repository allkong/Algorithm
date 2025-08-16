import sys
input = sys.stdin.readline

def dfs(start, depth):
    if depth == M:
        print(*path)
        return

    prev = None
    for i in range(start, N):
        if num[i] != prev:
            prev = num[i]
            path[depth] = num[i]
            dfs(i, depth + 1)

N, M = map(int, input().split())
num = sorted(map(int, input().split()))
selected = [False] * (N + 1)
path = [0] * M

dfs(0, 0)