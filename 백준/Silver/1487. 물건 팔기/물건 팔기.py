import sys
input = sys.stdin.readline

head_count = int(input())
buyer = []
for _ in range(head_count):
    buyer.append(list(map(int, input().split()))) # 각 사람이 지불할 최대 금액과 배송비
buyer.sort(key=lambda x:x[0]) # 낮은 가격 순으로 정렬

max_profit = 0
optimal_price = 0
for goods_price in buyer: # 판매 가격
    profit = 0 # goods_price[0] 가격으로 판매했을 때의 이익
    for purchase_price in buyer: # 구매 가격
        # 구매 가격이 판매 가격 이상이여야 구매 가능
        if purchase_price[0] >= goods_price[0]:
            revenue = goods_price[0] - purchase_price[1] # 판매 가격에서 배송비를 뺀 값
            # 수익이 있으면 더하기
            if revenue > 0:
                profit += revenue

    # 이전 판매 가격보다 이익이 더 크다면 판매할 가격 갱신
    if max_profit < profit:
        optimal_price = goods_price[0]
        max_profit = profit
print(optimal_price)