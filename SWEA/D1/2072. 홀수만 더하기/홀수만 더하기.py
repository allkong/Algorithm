T = int(input())
for case in range(1, T+1):
    tmp = 0
    num = list(map(int, input().split()))
    for n in num:
        if n % 2 != 0:
            tmp += n
    print("#%d %d" % (case, tmp))
