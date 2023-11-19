T = int(input())
for tc in range(1, T+1):
    n, m = map(int, input().split())
    board = []
    for i in range(n):
        board.append(list(map(int, input().split())))
    kill = []
    for i in range(n-m+1):
        for j in range(n-m+1):
            fly = 0
            for k in range(m):
                for l in range(m):
                    fly += board[j+k][i+l]
            kill.append(fly)
    print(f'#{tc}', max(kill))