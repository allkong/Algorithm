import sys
from collections import deque
input = sys.stdin.readline

def play():
    queue = deque([(S, 0)])

    while queue:
        current, cnt = queue.popleft()
        
        # 집에 도착하면 종료
        if current == D:
            return cnt

        # 앞으로 이동하거나 뒤로 이동
        for d in (F, -B):
            next = current + d

            if 0 < next <= N and not visited[next]:
                visited[next] = True
                queue.append((next, cnt + 1))

    return "BUG FOUND"

# 마포구 건물의 개수 N, 털린 금은방 S, 대도 X의 집 D, 앞으로 한 번에 달릴 수 있는 건물 수 F, 뒤로 한 번에 달릴 수 있는 건물 수 B, 마포구 경찰서의 개수 K
N, S, D, F, B, K = map(int, input().split())
# 마포구 경찰서의 건물 번호
police = list(map(int, input().split()))
visited = [False] * (N + 1)

for p in police:
    visited[p] = True

print(play())