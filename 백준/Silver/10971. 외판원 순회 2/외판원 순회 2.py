import sys
input = sys.stdin.readline

n = int(input())
visited = []
graph = [list(map(int, input().split())) for _ in range(n)]
min_cost = 1e9

def travel(start, next, cost, visited):
    global min_cost
    if len(visited) == n:
        if graph[next][start] != 0:
            min_cost = min(min_cost, cost + graph[next][start])
        return min_cost
    for i in range(n):
        if i not in visited and graph[next][i] != 0 and cost < min_cost:
            visited.append(i)
            travel(start, i, cost + graph[next][i], visited)
            visited.pop()

for i in range(n):
    travel(i, i, 0, [i])

print(min_cost)