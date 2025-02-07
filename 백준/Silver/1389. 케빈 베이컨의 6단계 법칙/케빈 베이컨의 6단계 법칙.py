import sys
input = sys.stdin.readline

n, m = map(int, input().split())
adj = [[n] * n for _ in range(n)]

# 자기 자신과의 거리 0으로 설정
for i in range(n):
    adj[i][i] = 0

# 간선 정보 입력
for _ in range(m):
    i, j = map(lambda x: int(x) - 1, input().split())
    adj[i][j] = adj[j][i] = 1

# Floyd-Warshall 알고리즘
for k in range(n):
    for i in range(n):
        for j in range(n):
            adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j])

# 케빈 베이컨 수 계산 및 최솟값 인덱스 찾기
print(min(range(n), key=lambda i: sum(adj[i])) + 1)