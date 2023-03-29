import sys
input = sys.stdin.readline

n = int(input())
time = [[0, 0]] * n
for i in range(n):
    time[i] =  list(map(int, input().split()))

time.sort(key = lambda x: (x[1], x[0]))

end, cnt = 0, 0
for s, e in time:
    if s >= end:
        cnt += 1
        end = e

print(cnt)