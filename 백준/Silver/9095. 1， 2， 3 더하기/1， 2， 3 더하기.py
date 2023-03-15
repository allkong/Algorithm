import sys
input = sys.stdin.readline

t = int(input())

cnt = [0] * 11
cnt[1] = 1
cnt[2] = 2
cnt[3] = 4

for i in range(4, 11):
    cnt[i] = cnt[i-1] + cnt[i-2] + cnt[i-3]

for _ in range(t):
    n = int(input())
    print(cnt[n])