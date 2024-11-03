from collections import deque
import sys
input = sys.stdin.readline

def game_start():
    while(queue):
        cur_pos, cur_cnt = queue.popleft()

        # 100번 칸에 도착하면 종료한다
        if (cur_pos == 100):
            return cur_cnt

        # 주사위를 1부터 6 사이로 굴린다
        for i in range(1, 7):
            next = cur_pos + i

            # 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다
            if (next > 100):
                break

            # 이미 방문한 곳이면 넘어간다
            if visited[next]:
                continue

            # 다음 위치가 사다리랑 뱀 모두 아니면 주사위 칸만큼 이동하고
            # 다음 위치가 사다리거나 뱀이면 타고 이동한다
            queue.append((board[next], cur_cnt + 1))
            visited[next] = True
                
n, m = map(int, input().split()) # 사다리의 수, 뱀의 수
board = [i for i in range(101)] # 게임맵 (현재 숫자 칸 번호)
visited = [False] * 101

for _ in range(n + m):
    x, y = map(int, input().split())
    # 사다리나 뱀의 도착 좌표로 갱신한다
    board[x] = y

queue = deque([(1, 0)])
print(game_start())