import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input()) # 동전의 가지 수
    coins = list(map(int, input().split())) # 동전의 각 금액
    M = int(input()) # 목표 금액

    dp = [0] * (M + 1)
    dp[0] = 1

    for coin in coins:
        for i in range(1, M + 1):
            if i >= coin:
                dp[i] += dp[i - coin]
    
    print(dp[M])