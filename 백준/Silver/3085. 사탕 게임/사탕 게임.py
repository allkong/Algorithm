import sys
input = sys.stdin.readline

n = int(input())
board = [list(input().rstrip()) for _ in range(n)]
ans = 1

def candy():
    ans = 1
    for x in range(n):
        cntx = 1
        cnty = 1
        for y in range(n-1):
            if board[x][y] != board[x][y+1]:
                cnty = 1
            else:
                cnty += 1

            if board[y][x] != board[y+1][x]:
                cntx = 1
            else:
                cntx += 1
            
            ans = max(ans, cntx, cnty)

    return ans

for x in range(n):
    for y in range(n):
        if y+1 < n and board[x][y] != board[x][y+1]:
            board[x][y], board[x][y+1] = board[x][y+1], board[x][y]
            ans = max(ans, candy())
            board[x][y], board[x][y+1] = board[x][y+1], board[x][y]

        if x+1 < n and board[x][y] != board[x+1][y]:
            board[x][y], board[x+1][y] = board[x+1][y], board[x][y]
            ans = max(ans, candy())
            board[x][y], board[x+1][y] = board[x+1][y], board[x][y]

print(ans)