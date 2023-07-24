import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    coin = list(map(int, input().split()))
    m = int(input())

    dp = [0 for _ in range(m+1)]
    dp[0] = 1
    for c in coin:
        for i in range(1, m+1):
            if i >= c:
                dp[i] += dp[i-c]

    print(dp[m])