from collections import deque
import sys
input = sys.stdin.readline

def hide_and_seek():
    global min_time, count
    while(queue):
        x, time  = queue.popleft()

        if (x == k):
            # 이번에 걸린 시간이 최소 시간보다 덜 걸렸으면 최소 시간을 갱신한다
            # 도착 방법의 수도 초기화한다
            if time < min_time:
                min_time = time
                count = 1
            # 이번에 걸린 시간이 최소 시간과 같으면 새로운 방법으로 온 것이니 방법의 수를 1 늘린다
            elif time == min_time: 
                count += 1
        
        # 수빈이가 이동할 수 있는 경우의 수 3가지
        for nx in [x - 1, x + 1, x * 2]:
            if (nx < 0 or nx > 100_000):
                continue

            # 아직 방문하지 않았거나 최단 시간으로 다시 도달했다면 탐색한다
            if not visited[nx] or visited[nx] == time + 1:
                # 순간이동을 하면 1초 후에 (현재위치 * 2)로 이동한다
                # 걸으면 1초 후에 (현재위치 - 1) 또는 (현재위치 + 1)로 이동한다
                queue.append((nx, time + 1))
                visited[nx] = time + 1

n, k = map(int, input().split()) # 수빈이가 있는 위치, 동생이 있는 위치

queue = deque([(n, 0)]) # 시작 위치, 시간
visited = [0] * 100_001 # 방문 여부(index 좌표까지의 최소 시간)
visited[n] = 1 # 처음 위치 방문 처리
min_time = sys.maxsize # 동생에게 도달했을 때의 최소 시간
count  = 0 # 방법의 수

hide_and_seek()
print(min_time)
print(count)