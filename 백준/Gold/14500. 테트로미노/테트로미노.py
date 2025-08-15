import sys
input = sys.stdin.readline

def find_t(y, x):
    max_total = 0
    # ㅜ, ㅗ, ㅓ, ㅏ 모양 블록 탐색
    for case in t_d:
        total = 0

        for c in case:
            ny = y + c[0]
            nx = x + c[1]

            if not (0 <= ny < N) or not (0 <= nx < M):
                break

            total += board[ny][nx]
        max_total = max(max_total, total)
    return max_total

def dfs(y, x, cnt, total):
    global max_total

    if cnt == 4:
        max_total = max(max_total, total)
        return

    for dx, dy in d:
        ny = y + dy
        nx = x + dx

        if (0 <= ny < N) and (0 <= nx < M) and not visited[ny][nx]:
            visited[ny][nx] = True
            dfs(ny, nx, cnt + 1, total + board[ny][nx])
            visited[ny][nx] = False

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
max_total = 0

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]
t_d = [[(0, 0), (0, 1), (0, 2), (1, 1)],
       [(0, 0), (0, 1), (0, 2), (-1, 1)],
       [(0, 0), (1, -1), (1, 0), (2, 0)],
       [(0, 0), (1, 0), (1, 1), (2, 0)]]

for i in range(N):
    for j in range(M):
        visited[i][j] = True
        # ㅜ 모양 블록 찾기
        max_total = max(max_total, find_t(i, j))
        # ㅜ를 제외한 나머지 블록 찾기
        dfs(i, j, 1, board[i][j])
        visited[i][j] = False

print(max_total)