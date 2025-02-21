import sys
input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))
length = [1] * N

for i in range(N - 1):
    cnt = 1
    for j in range(i + 1, N):
        if arr[i] + cnt == arr[j]:
            cnt += 1
            length[j] = max(length[j], cnt)

print(max(length))