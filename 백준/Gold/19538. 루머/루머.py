import sys
from collections import deque
input = sys.stdin.readline

def spread_rumor():
    queue = deque()

    for s in spreader:
        time[s] = 0
        queue.append(s)

    while queue:
        cur = queue.popleft()

        for next in graph[cur]:
            if time[next] == -1:
                believe[next] += 1

                if believe[next] >= len(graph[next]) / 2:
                    time[next] = time[cur] + 1
                    queue.append((next))

N = int(input()) # 사람의 수
graph = [[] for _ in range(N + 1)]

# 주변인 정보 바탕으로 그래프 만들기
for i in range(1, N + 1):
    graph[i] = list(map(int, input().split()))[:-1] # 주변인

M = int(input()) # 최초 유포자의 수
spreader = list(map(int, input().split())) # 최초 유포자의 번호
time = [-1] * (N + 1) # 루머를 처음 믿기 시작한 시간
believe = [0] * (N + 1) # 루머를 믿은 주변인 수

spread_rumor()
print(*time[1:])