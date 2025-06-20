import sys
input = sys.stdin.readline

N, K = map(int, input().split()) # 애플파이의 개수, 먹으려는 애플파이의 개수
A = list(map(int, input().split())) # 애플파이의 맛있는 정도
pie = [0] # 애플파이의 맛있는 정도 누적합
ans = 0 # 먹을 애플파이의 맛의 합의 최댓값

# 누적합 구하기
for i in range(N):
    pie.append(pie[i] + A[i])

# 애플파의 맛의 합의 최댓값 구하기
for i in range(N):
    if i + K <= N:
        total = pie[i + K] - pie[i]
    else:
        total = pie[N] - pie[i] + pie[i + K - N]
    ans = max(ans, total)

print(ans)