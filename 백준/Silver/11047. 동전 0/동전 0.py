import sys
input = sys.stdin.readline

n, goal = map(int, input().split())
coins = [int(input()) for _ in range(n)][::-1]

count = 0
for coin in coins:
    if coin <= goal:
        count += goal // coin
        goal %= coin
print(count)