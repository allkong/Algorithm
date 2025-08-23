import sys
input = sys.stdin.readline

N = int(input()) # 토핑의 종류의 수
A, B = map(int, input().split()) # 도우의 가격, 토핑의 가격
C = int(input()) # 도우의 열량
D = sorted(list(int(input()) for _ in range(N)), reverse=True) # 각 토핑의 열량

price = A # 총 가격
cal = C # 총 열량
best = cal // price # 최고의 피자의 1원 당 열량

# 최고의 피자: 1원당 열량이 가장 높은 피자
for i in range(N):
    price += B
    cal += D[i]
    best = max(best, cal // price)

print(best)