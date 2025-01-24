import sys
import heapq
input = sys.stdin.readline

n, m = map(int, input().split()) # 선물 상자의 수, 아이들의 수
present = [-int(num) for num in input().split()] # 선물 상자에 들어있는 선물의 개수
children = list(map(int, input().split())) # 각 아이가 원하는 선물의 개수
heapq.heapify(present)

for child in children:
    x = -heapq.heappop(present)
    # 상자에 자신이 원하는 것보다 크거나 같은 개수의 선물이 들어있다면 선물을 가져간다다
    if x >= child:
        if (x - child) > 0:
            heapq.heappush(present, child - x)
    # 상자에 자신이 원하는 것보다 적은 개수의 선물이 들어있다면, 선물을 가져가지 못한다
    else:
        print(0)
        exit()
print(1)