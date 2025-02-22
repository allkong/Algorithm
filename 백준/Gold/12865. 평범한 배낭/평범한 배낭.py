import sys
input = sys.stdin.readline

N, K = map(int, input().split()) # 물품의 수, 버틸 수 있는 무게
items = [(0, 0)] + [tuple(map(int, input().split())) for _ in range(N)] # (무게, 가치)
knapsack = [[0] * (K + 1) for _ in range(N + 1)]

for i in range(1, N + 1): # 물품
    for w in range(1, K + 1): # 무게
        # 탐색 중인 물품이 배낭 무게보다 가볍거나 같으면, 배낭에 넣을 수 있다
        if items[i][0] <= w:
            # 현재 물품을 넣기 전에 다른 물품(들)이 들어있을 때의 가치와 이전 물품을 빼고 현재 물품을 넣었을 때의 가치를 비교한다
            knapsack[i][w] = max(knapsack[i - 1][w], knapsack[i - 1][w - items[i][0]] + items[i][1])
        # 배낭에 넣을 수 없다면 이전 값을 그대로 가져간다
        else:
            knapsack[i][w] = knapsack[i - 1][w]

print(knapsack[N][K])