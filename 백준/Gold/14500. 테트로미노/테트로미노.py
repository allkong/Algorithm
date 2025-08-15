import sys
input = sys.stdin.readline

def dfs(y, x, cnt, total):
    global max_total
    # 남은 블록의 값이 최댓값이어도 max_total을 넘지 못하면 종료
    if total + max_val * (4 - cnt) <= max_total:
        return

    # 블록 4개가 연결되면 테트로미노 완성
    if cnt == 4:
        max_total = max(max_total, total)
        return

    for dx, dy in d:
        ny = y + dy
        nx = x + dx

        if (0 <= ny < N) and (0 <= nx < M) and not visited[ny][nx]:
            visited[ny][nx] = True

            # ㅜ 모양 블록 처리
            if cnt == 2:    
                dfs(y, x, cnt + 1, total + board[ny][nx])

            dfs(ny, nx, cnt + 1, total + board[ny][nx])
            visited[ny][nx] = False

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
max_total = 0
max_val = max(map(max, board))

d = [(-1, 0), (1, 0), (0, -1), (0, 1)] # 상하좌우

# 모든 좌표를 시작점으로 탐색
for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, 1, board[i][j])
        visited[i][j] = False

print(max_total)