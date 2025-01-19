import sys
input = sys.stdin.readline

# 입력받은 식을 '-'로 쪼갠다
exprs = input().rstrip().split('-')

# '+'를 기준으로 다시 쪼개서 합을 구한다
num = [sum(map(int, expr.split('+'))) for expr in exprs]

# num 리스트 안의 숫자들을 뺀다
ans = num[0] - sum(num[1:])

print(ans)