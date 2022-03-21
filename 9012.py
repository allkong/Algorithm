n = int(input())
for i in range(n):
    vps = input()
    cnt = 0
    for v in vps:
        if v == '(':
            cnt += 1
        elif v == ')':
            cnt -= 1
        if cnt < 0:
            print('NO')
            break
    if cnt == 0:
        print('YES')
    elif cnt > 0:
        print('NO')