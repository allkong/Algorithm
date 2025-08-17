import sys
input = sys.stdin.readline

n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * i for i in range(1, n + 1)]
dp[0][0] = triangle[0][0]

for i in range(n - 1):
    for j in range(len(triangle[i])):
        dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j])
        dp[i + 1][j + 1] = max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1])

print(max(dp[-1]))