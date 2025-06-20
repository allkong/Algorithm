import sys
input = sys.stdin.readline

N, K = map(int, input().split()) # 애플파이의 개수, 먹으려는 애플파이의 개수
A = list(map(int, input().split())) # 애플파이의 맛있는 정도
A += A # 원형 처리

current = sum(A[:K])
ans = 0 # 먹을 애플파이의 맛의 합의 최댓값

# 애플파의 맛의 합의 최댓값 구하기
for i in range(K, N + K):
    # 현재 범위의 다음 값 더하고 이전 값 빼기
    current += A[i] - A[i - K]
    ans = max(ans, current)

print(ans)