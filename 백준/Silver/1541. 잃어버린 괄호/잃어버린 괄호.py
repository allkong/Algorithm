import sys
input = sys.stdin.readline

# '-'를 기준으로 식을 쪼갠갠다
exprs = input().rstrip().split('-')
num = []

# 쪼갠 식들을 각각 계산한다
# '+'를 기준으로 다시 쪼개서 합을 구한다
for expr in exprs:
    num.append(sum(map(int, expr.split('+'))))

# num 리스트 안의 식들을 계산한다
# num[0] - num[1] - ...
ans = num[0]
for i in range(1, len(num)):
    ans -= num[i]

print(ans)