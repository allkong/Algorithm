import heapq

n = int(input())
rooms = [list(map(int, input().split())) for _ in range(n)]
rooms = sorted(rooms, key=lambda x: x[0])

q = []
for room in rooms:
    if q and q[0] <= room[0]:
        heapq.heappop(q)
    heapq.heappush(q, room[1])

print(len(q))