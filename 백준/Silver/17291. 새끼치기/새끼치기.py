import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (max(N, 3) + 1)

dp[1], dp[2], dp[3] = 1, 2, 4

for i in range(4, N + 1):
    dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

    if i % 2 != 0:
        dp[i] += dp[i - 4]

print(dp[N])