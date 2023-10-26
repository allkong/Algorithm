for _ in range(1, 11):
    t = int(input())
    board = [list(map(int, input().split())) for _ in range(100)]    
    ans = 0
    for b in board:
        ans = max(ans, sum(b))
    
    for i in range(100):
        tmp = 0
        for j in range(100):
            tmp += board[j][i]
        ans = max(ans, tmp)
    
    tmp = 0
    for i in range(100):
        tmp += board[i][i]
    ans = max(ans, tmp)

    tmp = 0
    for i in range(100):
        tmp += board[i][99-i]
    ans = max(ans, tmp)

    print(f'#{t}', ans)