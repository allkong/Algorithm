from copy import deepcopy
import sys
input = sys.stdin.readline

def spray_smell():
    for x in range(n):
        for y in range(n):
            if smell[x][y][1]:
                smell[x][y][1] -= 1
            if board[x][y]:
                smell[x][y] = [board[x][y], k]

def move_shark():
    new_board = [[0] * n for _ in range(n)]
    
    for x in range(n):
        for y in range(n):
            if board[x][y]:
                flag = False
                shark = board[x][y] - 1
                d = dir_shark[shark] - 1
                for i in priority_shark[shark][d]:
                    nx = x + dx[i - 1]
                    ny = y + dy[i - 1]  

                    if 0 <= nx < n and 0 <= ny < n:
                        if not smell[nx][ny][1]:
                            flag = True
                            dir_shark[shark] = i
                            
                            if new_board[nx][ny]:
                                new_board[nx][ny] = min(new_board[nx][ny], board[x][y])
                            else:
                                new_board[nx][ny] = board[x][y]
                            break
                
                if flag:
                    continue

                for i in priority_shark[shark][d]:
                    nx = x + dx[i - 1]
                    ny = y + dy[i - 1] 

                    if 0 <= nx < n and 0 <= ny < n:
                        if smell[nx][ny][0] == board[x][y]:
                            dir_shark[shark] = i
                            new_board[nx][ny] = board[x][y]
                            break
        
    return new_board

n, m, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
dir_shark = list(map(int, input().split()))
priority_shark = [[list(map(int, input().split())) for _ in range(4)] for _ in range(m)]
smell = [[[0, 0]] * n for _ in range(n)]
sec = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while True:
    spray_smell()
    new_board = move_shark()
    board = new_board
    sec += 1

    flag = True
    for x in range(n):
        for y in range(n):
            if board[x][y] > 1:
                flag = False
    
    if flag:
        print(sec)
        break

    if sec >= 1000:
        print(-1)
        break