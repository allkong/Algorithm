import sys
input = sys.stdin.readline

n, k = map(int, input().split())
a = list(map(int, input().split()))

start, end = 0, 0
cnt = [0] * (max(a) + 1)
ans = 0

while end < n:
    if cnt[a[end]] < k:
        cnt[a[end]] += 1
        end += 1
    else:
        cnt[a[start]] -= 1
        start += 1
    ans = max(ans, end - start)

print(ans)