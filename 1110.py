n = int(input())
num = n
cnt = 0
while True:
    a = n // 10
    b = n % 10
    c = (a + b) % 10
    n = (b * 10) + c
    cnt += 1
    if n == num:
        break
print(cnt)
