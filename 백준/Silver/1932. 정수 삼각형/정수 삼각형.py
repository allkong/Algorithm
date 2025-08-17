import sys
input = sys.stdin.readline

n = int(input())
triangle = [list(map(int, input().split())) for _ in range(n)]

for i in range(1, n):
    for j in range(i + 1):
        if j == 0: # 맨 왼쪽
            triangle[i][j] += triangle[i - 1][j]
        elif j == i: # 맨 오른쪽
            triangle[i][j] += triangle[i - 1][j - 1]
        else: # 가운데
            triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])

print(max(triangle[-1]))