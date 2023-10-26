T = int(input())
for t in range(1, T+1):
    N = int(input())
    arr = [[] for _ in range(N)]

    for n in range(N):
        if n == 0:
            arr[n].append(1)
        elif n == 1:
            arr[n].append(1)
            arr[n].append(1)
        elif n >= 2:
            arr[n].append(1)
            for i in range(1, n):
                arr[n].append(arr[n-1][i-1] + arr[n-1][i])
            arr[n].append(1)
    
    print(f'#{t}')
    for a in arr:
        print(*a)