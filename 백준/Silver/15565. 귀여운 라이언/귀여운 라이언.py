import sys
input = sys.stdin.readline

n, k = map(int, input().split())
doll = list(map(int, input().split()))

start, end = 0, 0
cnt = [0] * 3
ans = 1_000_000

while start < n:
    if cnt[1] < k and end < n:
        cnt[doll[end]] += 1
        end += 1
    else:
        if cnt[1] >= k:
            ans = min(ans, end - start)
        cnt[doll[start]] -= 1
        start += 1

if ans == 1_000_000:
    print(-1)
else:
    print(ans)