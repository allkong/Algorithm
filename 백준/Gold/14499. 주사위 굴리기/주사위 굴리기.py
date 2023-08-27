import sys
input = sys.stdin.readline

n, m, x, y, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
move = map(int, input().split())
dice = [0, 0, 0, 0, 0, 0]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def roll(d):
    if d == 1:
        dice[1], dice[3], dice[4], dice[5] = dice[5], dice[4], dice[1], dice[3]
    elif d == 2:
        dice[1], dice[3], dice[4], dice[5] = dice[4], dice[5], dice[3], dice[1]
    elif d == 3:
        dice[0], dice[1], dice[2], dice[3] = dice[3], dice[0], dice[1], dice[2]
    else:
        dice[0], dice[1], dice[2], dice[3] = dice[1], dice[2], dice[3], dice[0]

for i in move:
    nx = x + dx[i-1]
    ny = y + dy[i-1]

    if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue

    roll(i)
    
    if board[nx][ny]:
        dice[1] = board[nx][ny]
        board[nx][ny] = 0
    else:
        board[nx][ny] = dice[1]
    
    x, y = nx, ny
    print(dice[3])