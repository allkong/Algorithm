import sys
input = sys.stdin.readline

h, w = map(int, input().split())
board = [list(input().rstrip()) for _ in range(h)]
area = 0
is_open = False

for i in range(h):
    for j in range(w):
        if board[i][j] in ('/', '\\'):
            area += 0.5    
            is_open = not is_open
        else:
            if is_open:
                area += 1

print(int(area))