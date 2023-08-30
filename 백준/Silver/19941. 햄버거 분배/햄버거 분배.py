import sys
input = sys.stdin.readline

n, k = map(int, input().split())
li = list(input())
cnt = 0
for i in range(n):
    if li[i] == 'P':
        for j in range(max(0, i-k), min(n, i+k+1)):
            if li[j] == 'H':
                li[j] = 0
                cnt += 1
                break

print(cnt)