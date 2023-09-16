import copy
import sys
input = sys.stdin.readline

def find_fish(target, board):
    for i in range(4):
        for j in range(4):
            if board[i][j][0] == target:
                return (i, j)

def move_fish(x_shark, y_shark, board):
    for target in range(1, 17):
        fish = find_fish(target, board)
    
        if fish:
            x, y = fish[0], fish[1]
            d = board[x][y][1]
            
            for i in range(8):
                nx = x + dir[(d + i) % 8][0]
                ny = y + dir[(d + i) % 8][1]

                if 0 <= nx < 4 and 0 <= ny < 4:
                    if not (nx == x_shark and ny == y_shark):
                        board[x][y][1] = (d + i) % 8
                        board[nx][ny], board[x][y] = board[x][y], board[nx][ny]
                        break

def shark_position(x_shark, y_shark, board):
    d = board[x_shark][y_shark][1]
    position = []
    for _ in range(3):
        x_shark += dir[d][0]
        y_shark += dir[d][1]

        if 0 <= x_shark < 4 and 0 <= y_shark < 4 and board[x_shark][y_shark][0]:
            position.append([x_shark, y_shark])

    return position

def move_shark(x_shark, y_shark, level, board):
    global ans
    board = copy.deepcopy(board)
    
    level += board[x_shark][y_shark][0]
    ans = max(ans, level)
    board[x_shark][y_shark][0] = 0

    move_fish(x_shark, y_shark, board)

    position = shark_position(x_shark, y_shark, board)
    if position:
        for nx_shark, ny_shark in position:
            move_shark(nx_shark, ny_shark, level, board)
    
    return ans

board = [[0] * 4 for _ in range(4)]
for i in range(4):
    tmp = list(map(int, input().split()))
    for j in range(4):
        board[i][j] = [tmp[j * 2], tmp[j * 2 + 1] - 1]

dir = [(-1, 0), (-1, -1), (0, -1), (1, -1), (1, 0), (1, 1), (0, 1), (-1, 1)]
ans = 0
print(move_shark(0, 0, 0, board))