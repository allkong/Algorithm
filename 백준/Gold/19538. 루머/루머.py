import sys
from collections import deque
input = sys.stdin.readline

# 주변인의 절반 이상이 루머를 믿는지
def is_believe(i, t):
    cnt = 0
    for c in graph[i]:
        # 본인보다 먼저 루머를 믿은 주변인 세기
        if time[c] != -1 and time[c] < t:
            cnt += 1
    return cnt >= len(graph[i]) / 2

def spread_rumor():
    queue = deque()

    for s in spreader:
        time[s] = 0
        queue.append((s, 0))

    while queue:
        cur, t = queue.popleft()

        for next in graph[cur]:
            if (time[next] == -1 or t + 1 < time[next]) and is_believe(next, t + 1):
                time[next] = t + 1
                queue.append((next, t + 1))

N = int(input()) # 사람의 수
graph = [[] for _ in range(N + 1)]

# 주변인 정보 바탕으로 그래프 만들기
for i in range(1, N + 1):
    connect = list(map(int, input().split())) # 주변인
    for c in connect[:-1]:
        graph[i].append(c)

M = int(input()) # 최초 유포자의 수
spreader = list(map(int, input().split())) # 최초 유포자의 번호
time = [-1] * (N + 1) # 루머를 처음 믿기 시작한 시간

spread_rumor()

print(*time[1:])