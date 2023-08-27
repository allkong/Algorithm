import sys
input = sys.stdin.readline

n, d = map(int, input().split())
road = [list(map(int, input().split())) for _ in range(n)]
graph = [i for i in range(d + 1)]

for i in range(d + 1):
    graph[i] = min(graph[i], graph[i - 1] + 1)
    for start, end, length in road:
        if i == start and end <= d:
            graph[end] = min(graph[end], graph[i] + length)

print(graph[-1])