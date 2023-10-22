T = int(input())
for i in range(1, T+1):
    N = int(input())
    board = [[0] * N for _ in range(N)]
    x, y, d, k = 0, -1, 0, 1
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    while True:
        if k > N*N:
            break

        nx = x + dx[d]
        ny = y + dy[d]

        if nx >= 0 and nx < N and ny >= 0 and ny < N and board[nx][ny] == 0:
            board[nx][ny] = k
            x, y = nx, ny
            k += 1

        else:
            d = (d + 1) % 4
            
    print(f'#{i}')
    for b in board:
        print(*b)