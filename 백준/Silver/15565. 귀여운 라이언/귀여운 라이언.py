import sys
input = sys.stdin.readline

n, k = map(int, input().split())
doll = list(map(int, input().split()))

start, end = 0, 0
cnt = [0] * 3
ans = n + 1

while start < n:
    if cnt[1] < k and end < n:
        cnt[doll[end]] += 1
        end += 1
    else:
        if cnt[1] >= k:
            ans = min(ans, end - start)
        cnt[doll[start]] -= 1
        start += 1

print(ans if ans < n + 1 else -1)