a, b = map(int, input().split())
cnt = 1
while b != a:
    tmp = b
    if b % 10 == 1:
        b //= 10
    elif b % 2 == 0:
        b //= 2
    if b == tmp:
        cnt = -1
        break
    cnt += 1
print(cnt)