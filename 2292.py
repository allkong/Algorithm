n = int(input())
cnt = 1
ans = 1
while n > cnt:
    cnt += 6 * ans
    ans += 1
print(ans)