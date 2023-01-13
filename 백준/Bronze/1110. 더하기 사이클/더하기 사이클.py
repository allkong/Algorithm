n = int(input())
num = n
cnt = 0
while True:
    n = (n % 10) * 10 + ((n // 10) + (n % 10)) % 10
    cnt += 1
    if n == num:
      break
print(cnt)