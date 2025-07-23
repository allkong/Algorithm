import sys
import heapq
input = sys.stdin.readline

N = int(input())
cards = []
cnt = 0

for _ in range(N):
    heapq.heappush(cards, int(input()))

while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)

    cnt += a + b

    heapq.heappush(cards, a + b)

print(cnt)