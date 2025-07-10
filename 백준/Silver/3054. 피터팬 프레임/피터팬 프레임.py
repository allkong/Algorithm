import sys
input = sys.stdin.readline

def decorate(s, pattern):
    for i in range(-mid, mid + 1):
        if board[mid + i][s + abs(i)] != '*':
            board[mid + i][s + abs(i)] = pattern
        board[mid + i][s + N - 1 - abs(i)] = pattern

word = input().rstrip()
N = 5
mid = N // 2
board = [['.'] * (N + (N - 1) * (len(word) - 1)) for _ in range(N)]

for i in range(len(word)):
    decorate(i * (N - 1), '*' if (i + 1) % 3 == 0 else '#')

for i in range(len(word)):
    board[mid][i * (N - 1) + mid] = word[i]

for row in board:
    print(*row, sep='')