import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (N + 1)

if N == 1:
    print(1)
elif N == 2:
    print(2)
elif N == 3:
    print(4)
else:
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for i in range(4, N + 1):
        tmp = dp[i - 1] + dp[i - 2] + dp[i - 3]

        if i % 2 == 0:
            dp[i] = tmp
        else:
            dp[i] = tmp + dp[i - 4]

    print(dp[-1])