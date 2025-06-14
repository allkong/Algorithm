import sys
input = sys.stdin.readline

N = int(input())
cnt = 0

for i in range(N):
    if str(i).find("50") > -1:
        cnt += 1
    cnt += 1

print(cnt)