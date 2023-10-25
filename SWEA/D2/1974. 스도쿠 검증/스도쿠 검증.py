def sudoku():
    for i in range(9):
        col = [0] * 10
        row = [0] * 10
        for j in range(9):
            col[board[i][j]] += 1
            if col[board[i][j]] != 1:
                return 0 
            
            row[board[j][i]] += 1
            if row[board[j][i]] != 1:
                return 0 

    for x in range(0, 9, 3):
        for y in range(0, 9, 3):
            grid = [0] * 10
            for i in range(3):
                for j in range(3):
                    grid[board[x+i][y+j]] += 1
                    if grid[board[x+i][y+j]] != 1:
                        return 0
    
    return 1

T = int(input())
for t in range(1, T+1):
    board = [list(map(int, input().split())) for _ in range(9)]
    flag = sudoku()
    print(f'#{t} {flag}')