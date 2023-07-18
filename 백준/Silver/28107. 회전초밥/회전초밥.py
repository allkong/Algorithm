import heapq
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
orders = [[] for _ in range(200_001)]

for i in range(n):
    k, *items = map(int, input().split())
    for item in items:
        heapq.heappush(orders[item], i)
        
menu = list(map(int, input().split()))
cnt = [0] * n

for sushi in menu:
    if orders[sushi]:
        cnt[heapq.heappop(orders[sushi])] += 1

print(*cnt, sep=' ')