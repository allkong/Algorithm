import sys
input = sys.stdin.readline

N, T = map(int, input().split())
carrots = [tuple(map(int, input().split())) for _ in range(N)]
carrots.sort(key=lambda x: x[1], reverse=True)

total = 0
for i in range(N):
    total += carrots[i][0] + carrots[i][1] * (T - i - 1)

print(total)