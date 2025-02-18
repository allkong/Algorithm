import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
ans = 0

for i in range(n):
    cnt = 1
    for j in range(i, n - 1):
        if arr[j] < arr[j + 1]:
            cnt += 1
        else:
            break
    ans = max(ans, cnt)

print(ans)