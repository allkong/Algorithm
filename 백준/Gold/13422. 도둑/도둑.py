import sys
input = sys.stdin.readline

def steal():
    if N == M:
        return int(sum(house) < K)
    
    total = sum(house[:M]) # 훔친 돈의 양
    cnt = int(total < K)# 돈을 훔치는 방법의 가짓수

    for i in range(1, N):
        # 현재 범위의 이전 값을 빼고 다음 값을 더하기
        total = total - house[i - 1] + house[(i + M - 1) % N]
    
        if total < K:
            cnt += 1
    
    return cnt

T = int(input())
for _ in range(T):
    # 마을에 있는 집의 개수 N(1 ≤ N ≤ 100,000)
    # 도둑이 돈을 훔칠 연속된 집의 개수 M(1 ≤ M ≤ N)
    # 자동 방범 장치가 작동하는 최소 돈의 양 K(1 ≤ K ≤ 1,000,000,000, K는 정수)
    N, M, K = map(int, input().split())

    # N개의 집에서 각각 보관중인 돈의 양
    house = list(map(int, input().split()))
    
    print(steal())