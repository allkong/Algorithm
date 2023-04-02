n = int(input())
ball = input()
red = ball.count('R')
blue = n - red
ans = min(red, blue)

cnt = 0
for i in range(n):
    if ball[i] != ball[0]:
        break
    cnt += 1
if ball[0] == 'R':
    ans = min(ans, red - cnt)
else:
    ans = min(ans, blue - cnt)

cnt = 0
for i in range(n-1, -1, -1):
    if ball[i] != ball[-1]:
        break
    cnt += 1
if ball[-1] == 'R':
    ans = min(ans, red - cnt)
else:
    ans = min(ans, blue - cnt)

print(ans)