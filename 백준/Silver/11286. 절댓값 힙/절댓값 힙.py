import heapq
import sys
input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    item = int(input())
    if item == 0:
        if heap:
            print(heapq.heappop(heap)[1])
        else:
            print(0)
    else:
        heapq.heappush(heap, (abs(item), item))