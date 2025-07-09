import sys
sys.setrecursionlimit(10 ** 8)
input = sys.stdin.readline

def is_connect(prev):
    if prev == N - 1:
        print("YES")
        exit()
    
    visited[prev] = True
    for next in stones[prev]:
        if not visited[next]:
            is_connect(next)

N, K = map(int, input().split())
A = list(map(int, input().split()))
stones = [[] for _ in range(N)]
visited = [False] * N

for i in range(N):
    for j in range(i + 1, N):
        power = (j - i) * (1 + abs(A[i] - A[j]))
        
        if power <= K:
            stones[i].append(j)

is_connect(0)
print("NO")