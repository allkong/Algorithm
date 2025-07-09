import sys
input = sys.stdin.readline

n = int(input())
x = list(map(int, input().split()))
total = sum(x)
ans = 0

for i in range(n):
    total -= x[i]
    ans += x[i] * total

print(ans)