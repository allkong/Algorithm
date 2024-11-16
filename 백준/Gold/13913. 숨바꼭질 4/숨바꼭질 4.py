from collections import deque
import sys
input = sys.stdin.readline

def hide_and_seek():
    while(queue):
        current = queue.popleft()

        # 동생을 찾으면 경로를 돌아본다
        if (current == k):
            path = []
            # 시작점으로 갈 때까지 이전 좌표로 이동한다
            while current != n:
                path.append(current)
                current = prev[current]
            path.append(n) # 시작점 추가
            # 도착점에서 시작점으로 돌아갔으니 거꾸로 반환한다
            return path[::-1]
        
        # 수빈이가 이동할 수 있는 경우의 수 3가지
        for next in [current - 1, current + 1, current * 2]:
            if (next < 0 or next > 100_000 or visited[next]):
                continue

            # 순간이동을 하면 1초 후에 (현재위치 * 2)로 이동한다
            # 걸으면 1초 후에 (현재위치 - 1) 또는 (현재위치 + 1)로 이동한다=
            queue.append((next))
            visited[next] = True
            prev[next] = current

n, k = map(int, input().split()) # 수빈이가 있는 위치, 동생이 있는 위치

queue = deque([n])
visited = [False] * 100_001
prev = [0] * 100_001

path = hide_and_seek()
print(len(path) - 1)
print(*path)