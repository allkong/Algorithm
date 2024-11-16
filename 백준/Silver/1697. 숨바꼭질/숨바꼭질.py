from collections import deque
import sys
input = sys.stdin.readline

def hide_and_seek():
    while(queue):
        current = queue.popleft()

        # 동생을 찾으면 걸린 시간을 반환한다
        if (current == k):
            return time[current]
        
        # 수빈이가 이동할 수 있는 경우의 수 3가지
        for next in [current - 1, current + 1, current * 2]:
            if (next < 0 or next > 100_000 or visited[next]):
                continue

            # 순간이동을 하면 1초 후에 (현재위치 * 2)로 이동한다
            # 걸으면 1초 후에 (현재위치 - 1) 또는 (현재위치 + 1)로 이동한다=
            queue.append((next))
            visited[next] = True
            time[next] = time[current] + 1

n, k = map(int, input().split()) # 수빈이가 있는 위치, 동생이 있는 위치

queue = deque([n])
time = [0] * 100_001
visited = [False] * 100_001

print(hide_and_seek())