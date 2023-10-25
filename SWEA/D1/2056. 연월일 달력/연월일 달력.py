day = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

T = int(input())
for t in range(1, T+1):
    flag = 1
    date = input()

    y = int(date[0:4])
    m = int(date[4:6])
    d = int(date[6:])

    if m < 1 or m > 12:
        flag = 0
    if d < 1 or d > day[m-1]:
        flag = 0
    
    if not flag:
        print(f'#{t}', -1)
    else:
        print(f'#{t} {y:04d}/{m:02d}/{d:02d}')