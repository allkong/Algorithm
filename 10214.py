t = int(input())
for i in range(t):
    yc = kc = 0
    for j in range(9):
        y, k = map(int, input().split())
        yc += y
        kc += k
    if yc > kc:
        print('Yonsei')
    elif yc < kc:
        print('Korea')
    else:
        print('Draw')